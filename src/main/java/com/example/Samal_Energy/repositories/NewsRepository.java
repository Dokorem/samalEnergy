package com.example.Samal_Energy.repositories;


import com.example.Samal_Energy.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
