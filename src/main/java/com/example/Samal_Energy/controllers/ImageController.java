package com.example.Samal_Energy.controllers;

import com.example.Samal_Energy.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @Autowired
    private ImageRepository imageRepository;

    @GetMapping("/images/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long id) {
        return imageRepository.findById(id).map(image -> ResponseEntity.ok()
                .contentType(MediaType.valueOf(image.getContentType()))
                .body(image.getBytes()))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
