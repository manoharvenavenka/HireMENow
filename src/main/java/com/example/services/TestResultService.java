package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Company;
import com.example.entity.TestResult;

@Service
public interface TestResultService {
	void addResults(TestResult testresult);
	TestResult getById(int resultId);
	List<TestResult> getAllresults();
	List<Object[]>  getScoreAndCountByResultAndUserId(int userId);
	

}
