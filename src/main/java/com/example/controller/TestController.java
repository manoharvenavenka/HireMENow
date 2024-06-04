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

import com.example.entity.Test;
import com.example.services.TestServices;

@Controller
@RequestMapping("api/v1")
public class TestController {
@Autowired
TestServices testServ;

@PostMapping("/addTest")
public ResponseEntity<Object> addtest(@RequestBody Test test){
	System.out.println("test=" + test);
	testServ.addTest(test);
	return new ResponseEntity<>("Test Added Welcome To Hire Me Now1111",HttpStatus.CREATED);
}

@GetMapping(value="/allTests")
public ResponseEntity<Object>  getAllTests(){
	List<Test> test =  testServ.getAllTests();
	ResponseEntity<Object> entity = new ResponseEntity<>(test,HttpStatus.OK);
	return entity;
}

@GetMapping(value="/getTest/{testId}")
public ResponseEntity<Object> getTest(@PathVariable("testId") int testId){
	Test test;
	
	if(testServ.isTestExist(testId)) {
		test=testServ.getTestById(testId);
		
	}else {
		test = null;
	}
	ResponseEntity<Object> entity = new ResponseEntity<>(test,HttpStatus.OK);
	return entity;
	
}


@DeleteMapping(value="/deleteTest/{testId}")
public ResponseEntity<Object> deleteTest(@PathVariable("testId") int testId){
	
	boolean flag;
	if(testServ.isTestExist(testId)) {
		flag = testServ.deleteTest(testId);
	}else {
		flag = false;
	}
	
	return new ResponseEntity<>(flag,HttpStatus.OK);
	
}



@PutMapping(value="/updateTest/{testId}")
public ResponseEntity<Object> updateVacancy(@PathVariable("testId") int testId, @RequestBody Test test)
{
	
	boolean flag;
	if(testServ.isTestExist(testId)) {
		flag = testServ.updateTest(test);
	}else {
		flag = false;
	}
	
	return new ResponseEntity<>(flag, HttpStatus.OK);
	
}

@GetMapping(value="/viewTest/{companyId}")
public ResponseEntity<Object> getTestByCid(@PathVariable("companyId") int companyId){
	
		List<Test> test=testServ.getTestByCompanyId(companyId);
		
	
	ResponseEntity<Object> entity = new ResponseEntity<>(test,HttpStatus.OK);
	return entity;
	
}

@GetMapping(value="/getTestByVacancyId/{vacancyId}")
public ResponseEntity<Object> getTestByVac(@PathVariable("vacancyId") int vacancyId){
	Test test;
	
	
		test=testServ.findVacancyId(vacancyId);
		
	
	ResponseEntity<Object> entity = new ResponseEntity<>(test,HttpStatus.OK);
	return entity;
	
}



}