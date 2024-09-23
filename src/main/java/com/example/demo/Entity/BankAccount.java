package com.example.demo.Entity;



import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accountHolderName;
    private double balance;

    @OneToMany(mappedBy = "account")
    private List<PaymentMode> paymentModes;

    // Getters and Setters
}
