package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "comments")
public class Comment {

    private int author;

    private String authorImage;

    private String authorFirstName;

    private long createdAt;

    @Id
    @GeneratedValue
    private int pk;

    private String text;

}
