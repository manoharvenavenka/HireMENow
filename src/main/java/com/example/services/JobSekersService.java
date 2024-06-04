package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.JobSekers;

@Service
public interface JobSekersService {

	public void addjobsekers(JobSekers jobsekers);

	public List<JobSekers> getAlladdJobsekers();

	public boolean isJobsekerExist(int userId);

	public JobSekers getJobsekerById(int userId);

	public boolean deleteJobseker(int userId);

	public boolean updateJobsekers(JobSekers jobsekers);

	public JobSekers loginvalidate(String email);

}
