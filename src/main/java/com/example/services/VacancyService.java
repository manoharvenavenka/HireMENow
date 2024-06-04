package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Vacancy;

@Service
public interface VacancyService {
	public void addVacancy(Vacancy vacancy) ;
		public List<Vacancy> getAllVacancies() ;
			public boolean isVacancyExist(int vacancyId) ;
				public Vacancy getVacancyById(int vacancyId) ;
					public boolean deleteVacancy(int vacancyId) ;
						public boolean updateVacancy(Vacancy vacancy) ;
							public List<Vacancy> getVacanciesByCompanyId(int companyId) ;
								public List<Object[]> findVacancyIdAndJobTitle(int companyId) ;

		}


