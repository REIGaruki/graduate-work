package ru.skypro.homework.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UpdateUser;
import ru.skypro.homework.model.User;
import ru.skypro.homework.service.ImageService;
import ru.skypro.homework.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final ImageService imageService;

    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestParam NewPassword newPassword) {
        if (userService.setPassword(newPassword)) {
            return ResponseEntity.ok().build();
        } else if (userService.authorized()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<User> getUser() {
        if (userService.authorized()) {
            return ResponseEntity.ok(userService.getUserInfo());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PatchMapping("/me")
    public ResponseEntity<UpdateUser> updateUser(@RequestBody UpdateUser updateUser) {
        if (userService.updateUser(updateUser)) {
            return ResponseEntity.ok(updateUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PatchMapping("/me/image")
    public ResponseEntity<?> updateUserImage(@RequestBody MultipartFile image) {
        if (imageService.updateUserImage(image)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
