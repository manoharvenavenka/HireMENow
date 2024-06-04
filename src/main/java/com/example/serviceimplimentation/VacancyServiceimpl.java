package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.Vacancy;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.VacancyRepository;
import com.example.services.VacancyService;

@Service
public class VacancyServiceimpl implements VacancyService{
@Autowired
VacancyRepository vacRep;

	@Override
	public void addVacancy(Vacancy vacancy) {
		// TODO Auto-generated method stub
		vacRep.save(vacancy);
		
		
	}
	@Override
	public List<Vacancy> getAllVacancies() {
		List<Vacancy> vacancyList = vacRep.findAll();
		return vacancyList;
		
		
		
	}

	@Override
	public boolean isVacancyExist(int vacancyId) {
		Optional<Vacancy> vacancy =vacRep.findById(vacancyId);
		if(vacancy.isPresent()) {
			
			return true;
		
		}
		
		return false;
		
	}
	
	

	@Override
	public Vacancy getVacancyById(int vacancyId) {
		Optional<Vacancy> vacancy =vacRep.findById(vacancyId);
		Vacancy vac;
		if(vacancy.isPresent()) {
			vac=vacancy.get();
		}else {
			throw new ResourceNotFoundException("Vacancy", "vacancyId", vacancyId);
		}
		return vac;
	}
	
	

	

	@Override
	public boolean deleteVacancy(int vacancyId) {
		Optional<Vacancy> vacancy =vacRep.findById(vacancyId);
		if(vacancy.isPresent()) {
			vacRep.deleteById(vacancyId);
			return true;
		}else {
		return false;
	}
	}

	
	@Override
	public boolean updateVacancy(Vacancy vacancy) {
		Optional<Vacancy> vacancy1 =vacRep.findById(vacancy.getVacancyId());
		if(vacancy1.isPresent()) {
			vacRep.save(vacancy);
			return true;
		
	}else {
		return false;
	}
		
	}

	@Override
	public List<Vacancy> getVacanciesByCompanyId(int companyId) {
		List<Vacancy> vacancyList = vacRep.findByCompany_CompanyId(companyId);
		return vacancyList;			
	}
	
	@Override
	public List<Object[]> findVacancyIdAndJobTitle(int companyId) {
		List<Object[]> vacancyList = vacRep.findVacancyIdAndJobTitleByCompanyId(companyId);
		return vacancyList;
	}
	
	
}


