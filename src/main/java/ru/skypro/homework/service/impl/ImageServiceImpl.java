package ru.skypro.homework.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repository.ImageRepository;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ImageServiceImpl implements ImageService {

    Logger logger = LoggerFactory.getLogger(ImageService.class);

    private final UserService userService;
    private final AdService adService;
    private final ImageRepository imageRepository;

    @Value("${path.to.images.folder}")
    private String imagesDir;

    public ImageServiceImpl(UserService userService, AdService adService, ImageRepository imageRepository) {
        this.userService = userService;
        this.adService = adService;
        this.imageRepository = imageRepository;
    }

    @Override
    public void updateUserImage(MultipartFile image) {
        String path = uploadImage(image);
    }

    @Override
    public void updateAdImage(int ad, MultipartFile image) {
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
        imageRepository.save(new Image());
        return filePath.toString();
    }

}
