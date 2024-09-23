package com.example.demo.Entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private int experience; // in years

    @ElementCollection
    private List<String> skills;

    public Candidate() {
    }

    public Candidate(String name, String email, int experience, List<String> skills) {
        this.name = name;
        this.email = email;
        this.experience = experience;
        this.skills = skills;
    }

    // Getters and setters
}
