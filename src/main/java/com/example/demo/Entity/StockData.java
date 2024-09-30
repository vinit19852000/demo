package com.example.demo.Entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class StockData {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String jsonData;
    
    

    @CreationTimestamp
    private LocalDateTime createdAt;
}
