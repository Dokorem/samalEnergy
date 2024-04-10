package com.example.Samal_Energy.controllers;

import com.example.Samal_Energy.models.Image;
import com.example.Samal_Energy.models.News;
import com.example.Samal_Energy.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news")
    public String newsPage(Model model) {
        model.addAttribute("news", newsService.listNews());
        return "news";
    }

    @GetMapping("/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage/news/add")
    public String addNewsPage(Model model) {
        return "news-add";
    }

    @PostMapping("/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage/news/create")
    public String addNewsPost(
            @RequestParam String newsTitle,
            @RequestParam String newsText,
            @RequestParam("newsImage") MultipartFile newsImage)
    {

        Image image = toImageEntity(newsImage);
        newsService.saveNews(image,new News(newsTitle, newsText, image));

        return "redirect:/samalEnergyReg/tempSamalEnergyAdmin/SamalEnergyAdminPage/news/add";
    }

    private Image toImageEntity(MultipartFile file) {
        Image image = new Image();
        try {
            image.setName(file.getName());
            image.setOriginalFileName(file.getOriginalFilename());
            image.setContentType(file.getContentType());
            image.setSize(file.getSize());
            image.setBytes(file.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }

}
