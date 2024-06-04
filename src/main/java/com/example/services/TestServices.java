package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Test;

@Service
public interface TestServices {
	



		public void addTest(Test test);
		
		public List<Test> getAllTests() ;
			
		


		public boolean isTestExist(int testId);
			
			
		

		public Test getTestById(int testId) ;
			
		
		
		
		

		public boolean deleteTest(int testId);
		
		
		
		

		public boolean updateTest(Test test) ;
		
		public List<Test> getTestByCompanyId(int companyId) ;
			
		public Test findVacancyId(int vacancyId) ;
		



}
