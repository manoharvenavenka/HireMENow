package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.JobSekers;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.JobSekersRepository;
import com.example.services.JobSekersService;

@Service
public class JobSekersServiecImpl implements JobSekersService{

	@Autowired
	JobSekersRepository jobrep;

	@Override
	public void addjobsekers(JobSekers jobsekers) {
		// TODO Auto-generated method stub
		jobrep.save(jobsekers);
	}
	
	@Override
	public List<JobSekers> getAlladdJobsekers() {
		List<JobSekers> jobsekerlist=jobrep.findAll();
		return jobsekerlist;
	}


	@Override
	public boolean isJobsekerExist(int userId) {
		Optional<JobSekers> jobsekers = jobrep.findById(userId);
		if(jobsekers.isPresent()) {
			return true;
		}else {
			return false;
		}
	}
 


	@Override
	public JobSekers  getJobsekerById(int userId) {
		// TODO Auto-generated method stub
		Optional<JobSekers> jobsekers = jobrep.findById(userId);
		JobSekers job;
		if(jobsekers.isPresent()) {
			job=jobsekers.get();
		}else {
			throw new ResourceNotFoundException("JobSekers","userId", userId);
		}
		return job;
			}


	@Override
	public boolean deleteJobseker(int userId) {
		Optional<JobSekers> Jobsekers = jobrep.findById(userId);
		if(Jobsekers.isPresent()) {
			jobrep.deleteById(userId);
			return true;
		}else {
			return false;
		}
	}


	@Override
	public boolean updateJobsekers(JobSekers jobsekers) {
Optional<JobSekers> jobseker1 = jobrep.findById(jobsekers.getUserId());
		
		if(jobseker1.isPresent()) {
			jobrep.save(jobsekers);
			return true;
			
			
		}else {
			return false;
		}
		
		}

	@Override
	public JobSekers loginvalidate(String email) {
		JobSekers job=jobrep.findByEmail(email);
		
		return job;
	}

	
	
}
