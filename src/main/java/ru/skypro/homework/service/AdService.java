package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.Ads;
import ru.skypro.homework.dto.Comments;
import ru.skypro.homework.dto.CreateOrUpdateAd;
import ru.skypro.homework.dto.ExtendedAd;
import ru.skypro.homework.model.Ad;

import java.io.IOException;

public interface AdService {

    Ad addAd(CreateOrUpdateAd ad, MultipartFile image);
    Ads getAllAds();
    boolean exists(int id);
    Comments getComments(int id);
    ExtendedAd getExtendedAd(int id);
    void deleteAd(int id);
    Ad updateAd(int id, CreateOrUpdateAd adUpdate);
    Ads getAdsByUser();
    boolean changeImage(int id, MultipartFile image) throws IOException;
}
