package com.example.Samal_Energy.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "originalFileName")
    private String originalFileName;

    @Column(name = "size")
    private Long size;

    @Column(name = "contentType")
    private String contentType;

    @Lob
    @Column(name = "bytes", columnDefinition = "longblob")
    private byte[] bytes;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private News news;



}
