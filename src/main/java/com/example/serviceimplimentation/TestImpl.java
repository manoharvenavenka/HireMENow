package com.example.serviceimplimentation;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Test;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.TestRepository;
import com.example.services.TestServices;

@Service
public class TestImpl implements TestServices{
	@Autowired
	TestRepository testRepos;

	@Override
	public void addTest(Test test) {
		// TODO Auto-generated method stub
		testRepos.save(test);
	}
	@Override
	public List<Test> getAllTests() {
		List<Test> testList = testRepos.findAll();
		return testList;
	}
	


	@Override
	public boolean isTestExist(int testId) {
		Optional<Test> test = testRepos.findById(testId);
		if(test.isPresent()) {
			return true;
	}
		return false;
	}
		
	

	@Override
	public Test getTestById(int testId) {
		Optional<Test> test =testRepos.findById(testId);
		Test t;
		if( test.isPresent()) {
			t= test.get();
		}else {
			throw new ResourceNotFoundException("Test", "testId", testId);
		}
		return t;
	}
	
	
	
	
	

	@Override
	public boolean deleteTest(int testId) {
		Optional<Test> test =testRepos.findById(testId);
		if(test.isPresent()) {
			testRepos.deleteById(testId);
			return true;
		}
		else 
		{
		return false;
	}
		
	}
	
	

	@Override
	public boolean updateTest(Test test) {
		Optional<Test> test1 =testRepos.findById(test.getTestId());
		if(test1.isPresent()) {
			testRepos.save(test);
			return true;
		
	}else {
		return false;
	}

	}
	@Override
	public List<Test> getTestByCompanyId(int companyId) {
		 List<Test> tests = testRepos.findByCompanyId(companyId);
	        
		 if (tests.isEmpty()) {
	            return Collections.emptyList(); // Return empty list if no tests are found
	        }
	        
	        return tests;
	    }
	@Override
	public Test findVacancyId(int vacancyId) {
		Test test =testRepos.findOneByVacancy_VacancyId(vacancyId);
		
		
		return test;
	}

	  
	}


