package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Vacancy;
@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer>{
	
	  List<Vacancy> findByCompany_CompanyId(int companyId);
    
	  
	  
	  @Query("SELECT v.vacancyId, v.jobTitle FROM vacancy v WHERE v.company.companyId = :companyId")
	    List<Object[]> findVacancyIdAndJobTitleByCompanyId(int companyId);
	}
