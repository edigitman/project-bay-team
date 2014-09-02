package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Company;

public interface CompanyService {

	List<Company> findAll();

	Company findById(Integer id);
	
	Company save(Company company);
}
