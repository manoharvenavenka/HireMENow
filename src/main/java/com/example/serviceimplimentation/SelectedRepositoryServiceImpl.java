package com.example.serviceimplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.SelectedCandidates;
import com.example.repository.SelectedCanditateRepository;
import com.example.services.SelectedCanditateService;
@Service
public class SelectedRepositoryServiceImpl implements SelectedCanditateService{
@Autowired
SelectedCanditateRepository selectrepo;

@Override
public void addSelectedCanditates(SelectedCandidates candidates) {
	// TODO Auto-generated method stub
	selectrepo.save(candidates);
}

@Override
public List<SelectedCandidates> getAllSelectedList() {
	List<SelectedCandidates> selec=selectrepo.findAll();
	return selec;
}

@Override
public boolean existsByUserId(int userId,int vacancyId) {
	 List<Integer> selected = selectrepo.findIdsByJobSekersUserIdAndVacancyId(userId, vacancyId);
	    if (!selected.isEmpty()) {
	        return true; // User has applied for this vacancy
	    } else {
	        return false; // User has not applied for this vacancy
	    }
	}

@Override
public List<SelectedCandidates> findByVacancy_Company_CompanyId(int companyId) {
	List<SelectedCandidates> list=selectrepo.findByVacancy_Company_CompanyId(companyId);
			return list;
}
}



