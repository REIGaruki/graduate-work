package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "ads")
public class Ad {

    private int author;

    private String image;

    @Id
    @GeneratedValue
    private int pk;

    private int price;

    private String title;

    private String description;

}
