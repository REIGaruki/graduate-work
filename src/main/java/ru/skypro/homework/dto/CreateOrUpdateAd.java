package ru.skypro.homework.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class CreateOrUpdateAd {

    @Size(min = 4, max = 32)
    private String title;
    @Min(value = 0)
    @Max(value = 10000000)
    private int price;
    @Size(min = 8, max = 64)
    String description;

}
