package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Account;
import com.example.demo.Repo.AccountRepo;



@RestController
@RequestMapping("/natwestgroup/")


public class NatWestGroup {

	
	@Autowired
	AccountRepo accountRepo;
	
	@GetMapping("read-about-project")
	@Order(1)
	public ResponseEntity<Object> readme(){
		
		String document="";
		
		document=document+"     STEPS    "+"\n\n\n";
		document=document+"1.I have Created Bank Operation api's For Account opening,view,update functionality"+"\n";
		document=document+"2.Then Created Docker Image for this springboot application"+"\n";
		document=document+"3.Upload the code on github"+"\n";
		document=document+"4.Deploy On render which is opensource cloud Application Hosting"+"\n";
		document=document+"5.Set Up CI-CD pipeline for automation";
		
		return ResponseEntity.ok(document);
		
	}
	
	@PostMapping("open-bank-account")
	
	public ResponseEntity<Object> newAccount(@RequestBody Account account){
		
		if(account.getAge()<18)
		{
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Too Small For Open Account");
		}
		accountRepo.save(account);
		return ResponseEntity.ok("Account Created");
	}
	
	@PutMapping("update-bank-account")

	public ResponseEntity<Object> updateAccount(@RequestBody Account account){
		
		accountRepo.save(account);
		return ResponseEntity.ok("Account Details Updated");
	}
	
	
	@GetMapping("view-account-details")
	
	public ResponseEntity<Object> getAccount(@RequestParam Long accounNo){
		
		Optional<Account> acOptional=accountRepo.findById(accounNo);
		
		return (acOptional.isPresent())?ResponseEntity.ok(acOptional.get()):ResponseEntity.status(HttpStatus.ACCEPTED).body("No Details Found");
	}
	
	
	@GetMapping("view-balance")

	public ResponseEntity<Double> getBalnce(@RequestParam Long accounNo){
		
		Optional<Account> acOptional=accountRepo.findById(accounNo);
		
		return (acOptional.isPresent())?ResponseEntity.ok(acOptional.get().getBalance()):ResponseEntity.ok(0.00);
	}
	
	@DeleteMapping("delete-bank-account")
	
	public ResponseEntity<Object> deleteAccount(@RequestBody Account account){
		accountRepo.delete(account);
		return ResponseEntity.ok("Account Deleted Sucessfully");
	}
	
}
