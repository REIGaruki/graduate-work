package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue
    private int pk;

    private String path;

}
