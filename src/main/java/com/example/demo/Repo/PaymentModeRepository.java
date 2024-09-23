package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.PaymentMode;

public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long> {
}
