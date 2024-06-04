package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.JobApply;
import com.example.entity.JobSekers;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.JobApplayRepository;
import com.example.services.JobApplayService;


@Service
public class JobapplayServiceImpl implements JobApplayService{
@Autowired
JobApplayRepository jobrep;

@Override
public void addJobapplay(JobApply jobapply) {
jobrep.save(jobapply);
	
}

@Override
public List<JobApply> getJobsekersByUserId(int userId) {
	List<JobApply> jobList=jobrep.findByJobsekersUserId(userId);
	return jobList;
}

@Override
@Transactional
public void updateStatusByUserId(int userId,int vacancyId, String status,String finalScore) {
	jobrep.updateStatusAndFinalScoreByUserIdAndVacancyId(userId, vacancyId, status, finalScore);}

@Override
public boolean existsApplyIdForUserId(int userId) {
    List<Integer> applyIds = jobrep.findApplyIdByUserId(userId);
    boolean applyIdsFound = !applyIds.isEmpty();
    
    if (applyIdsFound) {
        System.out.println("Apply IDs found for user with ID: " + userId);
    }
    
    return applyIdsFound;
}

@Override
public List<JobApply> getJobApply() {
	// TODO Auto-generated method stub
	 List<JobApply> applay=jobrep.findAll();
	return applay;
}

@Override
public List<JobApply> findByCom(int companyId) {
	List<JobApply> app=jobrep.findByCompanyId(companyId);
	return app;
}

@Override
public JobApply getJobApplyById(int applyId) {
	// TODO Auto-generated method stub
			Optional<JobApply> jooo = jobrep.findById(applyId);
			JobApply job;
			if(jooo.isPresent()) {
				job=jooo.get();
			}else {
				throw new ResourceNotFoundException("jooo","applyId", applyId);
			}
			return job;
				}
@Override
public boolean existsByVacancyIdAndUserId(int vacancyId, int userId) {
    List<Integer> applyIds = jobrep.findApplyIdByVacancyIdAndUserId(vacancyId, userId);
    if (!applyIds.isEmpty()) {
        return true; // User has applied for this vacancy
    } else {
        return false; // User has not applied for this vacancy
    }
}
}


