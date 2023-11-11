package com.example.projbackendforstudentsdata;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cllg;
    private String mobile;
    private String branch;
    private String name;
    private String wapp;
    private String residence;
    private String year;
}
