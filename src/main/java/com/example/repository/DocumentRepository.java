package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Documents;

public interface DocumentRepository extends JpaRepository<Documents,Integer>{
	List<Documents> findByJobsekersUserId(int userId);
	 
}
