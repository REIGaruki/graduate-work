package ru.skypro.homework.model;

import lombok.Data;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "ad_pk")
    Ad ad;

}
