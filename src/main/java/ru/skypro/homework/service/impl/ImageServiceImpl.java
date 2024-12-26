package ru.skypro.homework.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repository.AdRepository;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.repository.UserRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService {

    Logger logger = LoggerFactory.getLogger(ImageService.class);

    private final UserRepository userRepository;
    private final AdRepository adRepository;
    private final ImageRepository imageRepository;

    @Value("${path.to.images.folder}")
    private String imagesDir;

    public ImageServiceImpl(UserRepository userRepository, AdRepository adService, ImageRepository imageRepository) {
        this.userRepository = userRepository;
        this.adRepository = adService;
        this.imageRepository = imageRepository;
    }

    @Override
    public boolean updateUserImage(MultipartFile image) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserEmail = authentication.getName();
        Optional<User> optionalUser = userRepository.findByEmail(currentUserEmail);
        if (optionalUser.isPresent()) {
            String path = uploadImage(image);
            User currentUser = optionalUser.get();
            currentUser.setImage(path);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateAdImage(int ad, MultipartFile image) {
        Optional<Ad> optionalAd = adRepository.findById(ad);
        if (optionalAd.isPresent()) {
            String path = uploadImage(image);
            Ad adToUpdate = optionalAd.get();
            adToUpdate.setImage(path);
            adRepository.save(adToUpdate);
            return true;
        } else {
            return false;
        }
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private String uploadImage(MultipartFile image) {
        Image newImage = imageRepository.save(new Image());
        Path filePath = Path.of(imagesDir,
                "image" + newImage.getPk() + "." + getExtensions(image.getOriginalFilename()));
        newImage.setPath(filePath.toString());
        try {
            Files.write(filePath, image.getBytes());
        } catch (IOException e) {
            logger.error("IO exception is caught");
        }
        imageRepository.save(newImage);
        return newImage.getPath();
    }

}
