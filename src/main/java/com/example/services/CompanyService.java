package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Company;

@Service
public interface CompanyService {
	public void addcompany(Company company);

	public List<Company> getAllCompanys();

	public boolean isCompanyExist(int companyId);

	public Company getCompanyById(int companyId);

	public boolean deleteCompany(int companyId);

	public boolean updateCompany(Company company);

	public Company findByEmail(String email);

}
