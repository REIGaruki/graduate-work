package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    boolean updateUserImage(MultipartFile image);
    boolean updateAdImage(int ad, MultipartFile image);
}
