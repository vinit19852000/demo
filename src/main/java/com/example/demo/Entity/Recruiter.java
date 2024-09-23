package com.example.demo.Entity;


import java.util.List;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String company;
    private String email;

    @ElementCollection
    private List<String> preferredSkills;

    public Recruiter() {
    }

    public Recruiter(String name, String company, String email, List<String> preferredSkills) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.preferredSkills = preferredSkills;
    }

    // Getters and setters
}
