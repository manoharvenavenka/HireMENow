package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,String>{
	public Admin  findByUsernameAndPassword(String username,String password);
}
