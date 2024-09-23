package com.example.demo.Entity;



import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PaymentMode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modeType; // e.g., Credit Card, Bank Account
    private String details;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private BankAccount account;

    // Getters and Setters
}
