package com.example.demo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Account {

	
	@Id
	private Long accountNumber;
	
	private String name;
	private Long mobileNumber;
	private int age;
	private double balance;

}
