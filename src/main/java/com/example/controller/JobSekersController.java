package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Company;
import com.example.entity.JobSekers;
import com.example.services.JobSekersService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("api/v1")
public class JobSekersController {
@Autowired
JobSekersService jobServices;


@GetMapping("/jobEmail/{email}")
public ResponseEntity<Object> getCompany1(@PathVariable("email") String email) {
	JobSekers jobseeker;
	
		jobseeker = jobServices.loginvalidate(email);

	
	ResponseEntity<Object> entity = new ResponseEntity<>(jobseeker, HttpStatus.OK);
	return entity;
}


@PostMapping("/addJobseker")
public ResponseEntity<Object> addJobseker(@RequestBody JobSekers jobseker){
	jobServices.addjobsekers(jobseker);
	return new ResponseEntity<>("JobSeker Added Welcome To Hire Me Now",HttpStatus.CREATED);	
}

@GetMapping(value="/allJobsekers")
public ResponseEntity<Object> getAllJobsekers(){
	List<JobSekers> jobsekers = jobServices.getAlladdJobsekers();
	ResponseEntity<Object> entity = new ResponseEntity<>(jobsekers,HttpStatus.OK);
	return entity;
}

@GetMapping(value="/getJobsekers/{userId}")
public ResponseEntity<Object> getJobseker(@PathVariable("userId") int userId){
	JobSekers jobseker;
	
	if(jobServices.isJobsekerExist(userId)) {
		jobseker=jobServices.getJobsekerById(userId);
		
	}else {
		jobseker = null;
	}
	ResponseEntity<Object> entity = new ResponseEntity<>(jobseker,HttpStatus.OK);
	return entity;
	
}


@DeleteMapping(value="/deleteJobseker/{userId}")
public ResponseEntity<Object> deleteJobseker(@PathVariable("userId") int userId){
	
	boolean flag;
	if(jobServices.isJobsekerExist(userId)) {
		flag = jobServices.deleteJobseker(userId);
	}else {
		flag = false;
	}
	
	return new ResponseEntity<>(flag,HttpStatus.OK);
	
}



@PutMapping(value="/updateJobseker/{userId}")
public ResponseEntity<Object> updateVacancy(@PathVariable("userId") int userId, @RequestBody JobSekers jobsker)
{
	
	boolean flag;
	if(jobServices.isJobsekerExist(userId)) {
		flag = jobServices.updateJobsekers(jobsker);
	}else {
		flag = false;
	}
	
	return new ResponseEntity<>(flag, HttpStatus.OK);
	
}
}



