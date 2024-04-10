package com.example.Samal_Energy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="news")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {

    public News(String title, String text, Image image) {
        this.title = title;
        this.text = text;
        this.image = image;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="text")
    private String text;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY, mappedBy = "news")
    private Image image;

    @Column(name = "creatingTime")
    private String creatingTime;

    @PrePersist
    private void init() {
        image.setNews(this);
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yy");
        creatingTime = formatter.format(currentDate);
    }

}
