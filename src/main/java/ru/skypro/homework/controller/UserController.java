package ru.skypro.homework.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserController() {
    }

    @PostMapping("post")
    public void doSmth() {
        System.out.println("DO work");

    }

    @GetMapping("get")
    public int getNumberDouble(@RequestParam int number) {
        return number * 2;
    }

}
