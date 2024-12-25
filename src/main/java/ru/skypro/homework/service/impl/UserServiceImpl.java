package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.model.User;
import ru.skypro.homework.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean authorized() {
        return false;
    }

    @Override
    public boolean setPassword(NewPassword newPassword) {
        return false;
    }

    @Override
    public User getUserInfo() {
        return null;
    }

    @Override
    public boolean updateUser(UpdateUser updateUser) {
        return false;
    }

    @Override
    public boolean updateUserImage(String image) {
        return false;
    }
}
