package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.SelectedCandidates;
@Service
public interface SelectedCanditateService {
void addSelectedCanditates(SelectedCandidates candidates);
List<SelectedCandidates> getAllSelectedList();
boolean existsByUserId(int userId,int vacancyId);
List<SelectedCandidates> findByVacancy_Company_CompanyId(int companyId);

}
