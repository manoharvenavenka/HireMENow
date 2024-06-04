package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.JobApply;

@Service
public interface JobApplayService {
	public void addJobapplay(JobApply jobapply) ;
		public List<JobApply> getJobsekersByUserId(int userId) ;
			public void updateStatusByUserId(int userId,int vacancyId, String status,String finalScore) ;

				public boolean existsApplyIdForUserId(int userId) ;
					public List<JobApply> getJobApply() ;

						public List<JobApply> findByCom(int companyId) ;
							public JobApply getJobApplyById(int applyId) ;
								public boolean existsByVacancyIdAndUserId(int vacancyId, int userId) ;

	
	
}
