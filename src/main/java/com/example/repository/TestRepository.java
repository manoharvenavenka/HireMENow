package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
	@Query(value = "SELECT * FROM test WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancy WHERE company_Id = :companyId)", nativeQuery = true)
	List<Test> findByCompanyId(int companyId);
	
	
	@Query(value = "SELECT test_Id FROM test WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancy WHERE company_Id = :companyId)", nativeQuery = true)
    List<Integer> findTestIdsByCompanyId(int companyId);
	
	Test findOneByVacancy_VacancyId(int vacancyId);
	
}