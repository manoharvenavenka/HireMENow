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

import com.example.entity.Company;
import com.example.services.CompanyService;

import jakarta.servlet.ServletContext;


@Controller
@RequestMapping("api/v1")
public class CompanyController {
	@Autowired
	CompanyService companyserv;

	@Autowired
	ServletContext context;
	

	@PostMapping("/addCompany")
	public ResponseEntity<Object> addCompany(@RequestBody Company company) {
		companyserv.addcompany(company);
		return new ResponseEntity<>("Company Added Welcome To Hire Me Now", HttpStatus.CREATED);

	}

	@GetMapping("/allCompanies")
	public ResponseEntity<Object> getAllcompanies() {
		List<Company> company = companyserv.getAllCompanys();
		ResponseEntity<Object> entity = new ResponseEntity<>(company, HttpStatus.OK);
		
		String absolutePath = context.getRealPath("/");
		System.out.println("ABOSULTE PATH: " + absolutePath);

		return entity;
	}

	@GetMapping("/getCompany/{companyId}")
	public ResponseEntity<Object> getCompany(@PathVariable("companyId") int companyId) {
		Company company;
		if (companyserv.isCompanyExist(companyId)) {
			company = companyserv.getCompanyById(companyId);

		} else {
			company = null;
		}
		ResponseEntity<Object> entity = new ResponseEntity<>(company, HttpStatus.OK);
		return entity;
	}
	@GetMapping("/companyEmail/{email}")
	public ResponseEntity<Object> getCompany1(@PathVariable("email") String email) {
		Company company;
		
			company = companyserv.findByEmail(email);

		
		ResponseEntity<Object> entity = new ResponseEntity<>(company, HttpStatus.OK);
		return entity;
	}

	@DeleteMapping(value = "/deleteCompany/{companyId}")
	public ResponseEntity<Object> deleteCompany(@PathVariable("companyId") int companyId) {

		boolean flag;
		if (companyserv.isCompanyExist(companyId)) {
			flag = companyserv.deleteCompany(companyId);
		} else {
			flag = false;
		}

		return new ResponseEntity<>(flag, HttpStatus.OK);

	}

	@PutMapping(value = "/updateCompany/{companyId}")
	public ResponseEntity<Object> updateCompany
	(@PathVariable("companyId") int companyId,
			@RequestBody Company company) {
		boolean flag;
		if (companyserv.isCompanyExist(companyId)) {
			flag = companyserv.updateCompany(company);
			System.err.println("haiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		} else {
			flag = false;
System.out.println("failed");
		}

		return new ResponseEntity<>(flag, HttpStatus.OK);
	}

}
