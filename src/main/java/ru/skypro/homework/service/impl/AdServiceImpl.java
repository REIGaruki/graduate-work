package ru.skypro.homework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.dto.ExtendedAd;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.service.AdService;
import ru.skypro.homework.service.ImageService;

import java.io.IOException;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    ImageService imageService;

    @Override
    public Ad addAd(CreateOrUpdateAd ad, MultipartFile image) {
        return null;
    }

    @Override
    public Ads getAllAds() {
        return null;
    }

    @Override
    public boolean exists(int id) {
        return false;
    }

    @Override
    public Comments getComments(int id) {
        return null;
    }

    @Override
    public ExtendedAd getExtendedAd(int id) {
        return null;
    }

    @Override
    public void deleteAd(int id) {

    }

    @Override
    public Ad updateAd(int id, CreateOrUpdateAd adUpdate) {
        return null;
    }

    @Override
    public Ads getAdsByUser() {
        return null;
    }

    @Override
    public boolean changeImage(int id, MultipartFile image) throws IOException {
        return imageService.updateAdImage(id, image);
    }
}
