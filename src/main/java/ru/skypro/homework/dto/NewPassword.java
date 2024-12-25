package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class NewPassword {
    @Size(min=2, max=50)
    private String currentPassword;
    @Size(min=2, max=50)
    private String newPassword;

}
