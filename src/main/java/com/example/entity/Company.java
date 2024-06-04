package com.example.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity(name="company")

public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="companyId",nullable =false)
	private int companyId;
	
	@Column(name="companyName",nullable = false)
	private String companyName;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="registrationDate" )
	private String regDate;
	
	@Column(name="email" )
	private String email;
	
	@Column(name="mobileNumber",nullable = false )
	private String mobile;
	
	@Column(name="location",nullable = false )
	private String location;
	
	@Column(name="city",nullable = false )
	private String city;
	
	@Column(name="state",nullable = false )
	private String state;
	
	@Column(name="companyLevel" )
	private String companyLevel;
	
	@Column(name="url",nullable = false )
	private String url;
	
	@Column(name="logo" )
	private String logo;
	
	@Column(name="password" ,nullable = false)

	private String password;
	
	
	

}
