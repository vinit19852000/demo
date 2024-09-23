package com.example.demo.Repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Recruiter;

import java.util.List;

public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    List<Recruiter> findByPreferredSkillsIn(List<String> skills);
}
