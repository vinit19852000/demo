package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.StockData;


public interface Stockrepo extends JpaRepository<StockData, Long>{

    StockData findTopByOrderByCreatedAtDesc();
}
