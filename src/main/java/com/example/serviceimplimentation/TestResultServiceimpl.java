package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.loadtime.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.TestResult;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.TestResultRepository;
import com.example.services.TestResultService;
@Service
public class TestResultServiceimpl implements TestResultService{

	
	@Autowired
	TestResultRepository testrepo;

	@Override
	public void addResults(TestResult testresult) {
		// TODO Auto-generated method stub
		testrepo.save(testresult);
	}

	@Override
	public List<TestResult> getAllresults() {
		List<TestResult>testres=testrepo.findAll();
		return testres;
	}

	@Override
	public TestResult getById(int resultId) {
		Optional<TestResult> testResult =testrepo.findById(resultId);
		TestResult testres;
		if(testResult.isPresent()) {
			testres=testResult.get();
			
		}else {
			throw new ResourceNotFoundException("TestResult", "ResultId", resultId);
		}
		return testres;
	}

	@Override
	public List<Object[]> getScoreAndCountByResultAndUserId(int userId) {
		List<Object[]> testres=testrepo.getScoreAndCountByResultAndUserId(userId);
		return testres;
	}

}
