package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {
	@Query(value = "SELECT * FROM questions WHERE vacancy_Id IN (SELECT vacancy_Id FROM vacancy WHERE company_Id = :companyId)", nativeQuery = true)
	List<Questions> findByCompanyId(int companyId);

	List<Questions> findByVacancy_VacancyId(int vacancyId);
}
