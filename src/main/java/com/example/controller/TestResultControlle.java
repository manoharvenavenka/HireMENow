package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Company;
import com.example.entity.TestResult;
import com.example.services.TestResultService;

@Controller
@RequestMapping("api/v1")

public class TestResultControlle {

	
	@Autowired
	TestResultService testserv;
	
	
	@PostMapping("/addResult")
	public ResponseEntity<Object> addJobseker(@RequestBody TestResult testresult){
		testserv.addResults(testresult);
		return new ResponseEntity<>("Tset Added Welcome To Hire Me Now",HttpStatus.CREATED);	
	}
	@GetMapping("/allRes")
	public ResponseEntity<Object> getAllres() {
		List<TestResult> testresult = testserv.getAllresults();
		ResponseEntity<Object> entity = new ResponseEntity<>(testresult, HttpStatus.OK);

		return entity;
	}
	
	@GetMapping("/getResultsBy/{resultId}")
	public ResponseEntity<Object> getResultById(@PathVariable("resultId")int resultId) {
		TestResult testresult = testserv.getById(resultId);
		ResponseEntity<Object> entity = new ResponseEntity<>(testresult, HttpStatus.OK);

		return entity;
	}
	@GetMapping("/getResultsOfUser/{userId}")
	public ResponseEntity<Object> getResult(@PathVariable("userId")int userId) {
		List<Object[]> testresult = testserv.getScoreAndCountByResultAndUserId(userId);
		ResponseEntity<Object> entity = new ResponseEntity<>(testresult, HttpStatus.OK);

		return entity;
	}
	

}
