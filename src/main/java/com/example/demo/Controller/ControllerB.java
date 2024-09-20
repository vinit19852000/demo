package com.example.demo.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Object.Company;


@RestController
@RequestMapping("/companyB")

public class ControllerB {
	
	HashMap<String,Company> hmap=new HashMap<String, Company>();
	
	@GetMapping("/view/{name}")
	public ResponseEntity<Company> getCompanyName(@PathVariable("name") String name){
		
		return ResponseEntity.ok((hmap.containsKey(name)?hmap.get(name):new Company()) );
	}
	@GetMapping("/viewAll")
	public ResponseEntity< List<Company>> getCompanies(){
		   List<Company> companies = hmap.entrySet().stream()// Filter by name if needed
			        .map(Map.Entry::getValue) // Extract the Company object
			        .collect(Collectors.toList());

		return ResponseEntity.ok(companies);
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<Company> save(@RequestBody Company company){
		
		  hmap.put(company.getCompany(), company);
		  
		  return ResponseEntity.ok(company);
	}
	@PutMapping("/update")
	public ResponseEntity<Company> update(@RequestBody Company company){
		
		  hmap.put(company.getCompany(), company);
		  
		  return ResponseEntity.ok(company);
	}

}
