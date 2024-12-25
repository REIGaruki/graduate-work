package ru.skypro.homework.service;

import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.model.User;

public interface UserService {

    boolean authorized();
    boolean setPassword(NewPassword newPassword);
    User getUserInfo();
    boolean updateUser(UpdateUser updateUser);
    boolean updateUserImage(String image);
}
