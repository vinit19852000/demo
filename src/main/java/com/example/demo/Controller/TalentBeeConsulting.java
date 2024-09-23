package com.example.demo.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Candidate;
import com.example.demo.Entity.Recruiter;
import com.example.demo.Repo.CandidateRepository;
import com.example.demo.Repo.RecruiterRepository;

import java.util.List;

@RestController
@RequestMapping("/JobPortal")
public class TalentBeeConsulting {

    @Autowired
    private RecruiterRepository recruiterRepository;

    @Autowired
    private CandidateRepository candidateRepository;

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
	
    // Register recruiter
    @PostMapping("/register-recruiter")
    public ResponseEntity<Recruiter> registerRecruiter(@RequestBody Recruiter recruiter) {
        Recruiter savedRecruiter = recruiterRepository.save(recruiter);
        return ResponseEntity.ok(savedRecruiter);
    }

    // Register candidate
    @PostMapping("/register-candidate")
    public ResponseEntity<Candidate> registerCandidate(@RequestBody Candidate candidate) {
        Candidate savedCandidate = candidateRepository.save(candidate);
        return ResponseEntity.ok(savedCandidate);
    }

    // Search candidates based on preferred skills
    @GetMapping("/search-candidates")
    public ResponseEntity<List<Candidate>> searchCandidates(@RequestParam List<String> skills) {
        List<Candidate> candidates = candidateRepository.findBySkillsIn(skills);
        return ResponseEntity.ok(candidates);
    }

    // Search recruiters based on skills
    @GetMapping("/search-recruiters")
    public ResponseEntity<List<Recruiter>> searchRecruiters(@RequestParam List<String> skills) {
        List<Recruiter> recruiters = recruiterRepository.findByPreferredSkillsIn(skills);
        return ResponseEntity.ok(recruiters);
        
        

    }
    
    @GetMapping("/view-all-candidates")
    public ResponseEntity<List<Candidate>> viewCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        return ResponseEntity.ok(candidates);
    }

    @GetMapping("/view-all-recruiters")
    public ResponseEntity<List<Recruiter>> viewRecruiters() {
        List<Recruiter> recruiters = recruiterRepository.findAll();
        return ResponseEntity.ok(recruiters);
        
        

    }
}
