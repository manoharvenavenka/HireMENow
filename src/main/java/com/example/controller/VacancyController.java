package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Vacancy;
import com.example.services.VacancyService;

@Controller
@RequestMapping("api/v1")
public class VacancyController {
@Autowired
VacancyService vacancyserv;

@PostMapping("/addVacancy")
public ResponseEntity<Object> addVacancy(@RequestBody Vacancy vacancy){
	vacancyserv.addVacancy(vacancy);
	return new ResponseEntity<>("Vacancy Added Welcome To Hire Me Now",HttpStatus.CREATED);
}

@GetMapping(value="/allVacancies")
public ResponseEntity<Object> getAllVacancies(){
	List<Vacancy> vacancy = vacancyserv.getAllVacancies();
	ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
	return entity;
}


@GetMapping(value="/vacancyIdAndJobtitle/{companyId}")
public ResponseEntity<Object> getAllVacanciesIds(@PathVariable("companyId") int companyId){
	List<Object[]> vacancy = vacancyserv.findVacancyIdAndJobTitle(companyId);
	ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
	return entity;
}


@GetMapping(value="/getVacancies/{companyId}")
public ResponseEntity<Object> getByCId(@PathVariable("companyId") int companyId){
	List<Vacancy> vacancy = vacancyserv.getVacanciesByCompanyId(companyId);
	ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
	return entity;
}





@GetMapping(value="/getVacancy/{vacancyId}")
public ResponseEntity<Object> getVacancy(@PathVariable("vacancyId") int vacancyId){
	Vacancy vacancy;
	
	if(vacancyserv.isVacancyExist(vacancyId)) {
		vacancy=vacancyserv.getVacancyById(vacancyId);
		
	}else {
		vacancy = null;
	}
	ResponseEntity<Object> entity = new ResponseEntity<>(vacancy,HttpStatus.OK);
	return entity;
	
}


@DeleteMapping(value="/deleteVacancy/{vacancyId}")
public ResponseEntity<Object> deleteVacancy(@PathVariable("vacancyId") int vacancyId){
	
	boolean flag;
	if(vacancyserv.isVacancyExist(vacancyId)) {
		flag = vacancyserv.deleteVacancy(vacancyId);
	}else {
		flag = false;
	}
	
	return new ResponseEntity<>(flag,HttpStatus.OK);
	
}



@PutMapping(value="/updateVacancy/{vacancyId}")
public ResponseEntity<Object> updateVacancy(@PathVariable("vacancyId") int vacancyId, @RequestBody Vacancy vacancy)
{
	
	boolean flag;
	if(vacancyserv.isVacancyExist(vacancyId)) {
		flag = vacancyserv.updateVacancy(vacancy);
	}else {
		flag = false;
	}
	
	return new ResponseEntity<>(flag, HttpStatus.OK);
	
}

}
