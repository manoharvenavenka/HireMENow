package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.Company;
import com.example.entity.SelectedCandidates;
import com.example.services.SelectedCanditateService;

@Controller
@RequestMapping("api/v1")
public class SelectedCanditatesController {

	@Autowired
	SelectedCanditateService selectedservice;
	
	@PostMapping("/addSelectedCanditates")
	public ResponseEntity<Object> addCompany(@RequestBody SelectedCandidates candidates) {
		selectedservice.addSelectedCanditates(candidates);
		return new ResponseEntity<>("selected canditates Added Welcome To Hire Me Now", HttpStatus.CREATED);

	}
	@GetMapping("/allSelected")
	public ResponseEntity<Object> getAllSelected() {
		List<SelectedCandidates> selected = selectedservice.getAllSelectedList();
		ResponseEntity<Object> entity = new ResponseEntity<>(selected, HttpStatus.OK);

		return entity;
	}
	 @GetMapping("/checkSlected/{userId}/{vacancyId}")
	    public ResponseEntity<Boolean> checkJobApplication(@PathVariable("userId") int userId,@PathVariable("vacancyId") int vacancyId) {
	        boolean exists = selectedservice.existsByUserId(userId, vacancyId);
	        return ResponseEntity.ok(exists);
	    }
	 
	 @GetMapping("/getSelected/{companyId}")
		public ResponseEntity<Object> getSelectedByCompanyId(@PathVariable("companyId")int companyId) {
			List<SelectedCandidates> selected = selectedservice.findByVacancy_Company_CompanyId(companyId);
			ResponseEntity<Object> entity = new ResponseEntity<>(selected, HttpStatus.OK);

			return entity;
		}
}
