package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.SelectedCandidates;

public interface SelectedCanditateRepository extends JpaRepository<SelectedCandidates, Integer>{
	@Query(value = "SELECT s.id FROM SelectedCandidates s WHERE s.jobSekers.userId = :userId AND s.vacancy.vacancyId = :vacancyId")
	List<Integer> findIdsByJobSekersUserIdAndVacancyId(int userId, int vacancyId);

    List<SelectedCandidates> findByVacancy_Company_CompanyId(int companyId);

}
