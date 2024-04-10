package com.example.Samal_Energy.service;

import com.example.Samal_Energy.models.Image;
import com.example.Samal_Energy.models.News;
import com.example.Samal_Energy.repositories.ImageRepository;
import com.example.Samal_Energy.repositories.NewsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NewsService {

    private final NewsRepository newsRepository;
    private final ImageRepository imageRepository;

    public List<News> listNews() {
        List<News> list = newsRepository.findAll();
        Collections.reverse(list);
        return list;
    }

    public void saveNews(Image image, News news) {
        imageRepository.save(image);
        newsRepository.save(news);
    }

}
