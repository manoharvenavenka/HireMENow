package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.JobApply;
import com.example.entity.JobSekers;
import com.example.entity.Test;
import com.example.services.JobApplayService;

@Controller
@RequestMapping("api/v1")
public class JobApplayController {
	@Autowired
	JobApplayService jobappserv;

	@PostMapping("/addJobApplay")
	public ResponseEntity<Object> addVacancy(@RequestBody JobApply jobapply) {
		jobappserv.addJobapplay(jobapply);
		return new ResponseEntity<>("Job Added Welcome To Hire Me Now", HttpStatus.CREATED);
	}

	@GetMapping(value = "/viewJobapplay/{userId}")
	public ResponseEntity<Object> getJobsbyUserId(@PathVariable("userId") int userId) {

		List<JobApply> job = jobappserv.getJobsekersByUserId(userId);

		ResponseEntity<Object> entity = new ResponseEntity<>(job, HttpStatus.OK);
		return entity;

	}
	
	@GetMapping(value = "/viewApplies/{companyId}")
	public ResponseEntity<Object> getJobappbycid(@PathVariable("companyId") int companyId) {

		List<JobApply> job = jobappserv.findByCom(companyId);

		ResponseEntity<Object> entity = new ResponseEntity<>(job, HttpStatus.OK);
		return entity;

	}
	
	
	@GetMapping(value = "/applies")
	public ResponseEntity<Object> getJobsApplay() {

		List<JobApply> job = jobappserv.getJobApply();

		ResponseEntity<Object> entity = new ResponseEntity<>(job, HttpStatus.OK);
		return entity;

	}

	@PutMapping("/updatestat/{userId}/{vacancyId}/{status}/{finalScore}")
	public ResponseEntity<String> updateStatusByUserId(@PathVariable int userId,
			@PathVariable String status,@PathVariable String finalScore,@PathVariable int vacancyId)

	{
		jobappserv.updateStatusByUserId(userId, vacancyId, status, finalScore);

		return ResponseEntity.ok("Status updated successfully");
	}
	
	@GetMapping(value="/getApplicants/{applyId}")
	public ResponseEntity<Object> getJobseker(@PathVariable("applyId") int applyId){
		JobApply jobseker;
		
		
			jobseker=jobappserv.getJobApplyById(applyId);
			
		
		ResponseEntity<Object> entity = new ResponseEntity<>(jobseker,HttpStatus.OK);
		return entity;
		
	}
	  @GetMapping("/check/{vacancyId}/{userId}")
	    public ResponseEntity<Boolean> checkJobApplication(@PathVariable int vacancyId, @PathVariable int userId) {
	        boolean exists = jobappserv.existsByVacancyIdAndUserId(vacancyId, userId);
	        return ResponseEntity.ok(exists);
	    }

}
