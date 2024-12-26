package ru.skypro.homework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.Register;
import ru.skypro.homework.mapper.UserMapper;
import ru.skypro.homework.service.AuthService;
import ru.skypro.homework.repository.UserRepository;
import ru.skypro.homework.model.User;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserDetailsManager manager;
    private final PasswordEncoder encoder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public AuthServiceImpl(UserDetailsManager manager, PasswordEncoder encoder, UserRepository userRepository, UserMapper userMapper) {
        this.manager = manager;
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(String userName, String password) {
        if (!manager.userExists(userName)) {
            return false;
        }
        UserDetails userDetails = manager.loadUserByUsername(userName);
        return encoder.matches(password, userDetails.getPassword());
    }

    @Override
    public boolean register(Register register) {
        if (userRepository.findByEmail(register.getUsername()).isPresent()) {
            return false;
        }
        User newUser = userMapper.mapFromRegister(register);
        newUser.setPassword(encoder.encode(register.getPassword()));
        userRepository.save(newUser);
        return true;
    }

}
