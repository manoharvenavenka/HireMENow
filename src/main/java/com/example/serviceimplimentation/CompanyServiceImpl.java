package com.example.serviceimplimentation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Company;
import com.example.exception.ResourceNotFoundException;
import com.example.repository.CompanyRepository;
import com.example.services.CompanyService;



@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyRepository compRep;
	
	
	
	@Override
	public void addcompany(Company company) {
		// TODO Auto-generated method stub
		
		compRep.save(company);
		
	}


	@Override
	public List<Company> getAllCompanys() {
		List<Company> companylist=compRep.findAll();
		return companylist;
	}


	@Override
	public boolean isCompanyExist(int companyId) {
		Optional<Company> company = compRep.findById(companyId);
		if(company.isPresent()) {
			return true;
		}else {
			return false;
		}
	}



	@Override
	public Company getCompanyById(int companyId) {
		// TODO Auto-generated method stub
		Optional<Company> company = compRep.findById(companyId);
		Company comp;
		if(company.isPresent()) {
			comp=company.get();
		}else {
			throw new ResourceNotFoundException("Company","companyId", companyId);
		}
		return comp;
			}


	@Override
	public boolean deleteCompany(int companyId) {
		Optional<Company> company = compRep.findById(companyId);
		if(company.isPresent()) {
			compRep.deleteById(companyId);
			return true;
		}else {
			return false;
		}
	}


	@Override
	public boolean updateCompany(Company company) {
Optional<Company> company1 = compRep.findById(company.getCompanyId());
		
		if(company1.isPresent()) {
			compRep.save(company);
			return true;
			
			
		}else {
			return false;
		}
		
		}


	


	@Override
	public Company findByEmail(String email) {
		Company company = compRep.findByEmail(email);
		
			
			return company;
		
	}


}

