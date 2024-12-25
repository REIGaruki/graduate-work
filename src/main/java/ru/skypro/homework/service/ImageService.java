package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void updateUserImage(MultipartFile image);
    void updateAdImage(int ad, MultipartFile image);
}
