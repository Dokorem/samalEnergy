package com.example.Samal_Energy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "mails")
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "message")
    private String message;

}
