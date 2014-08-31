package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Company;

public interface CompanyService {

	public List<Company> findAll();

	public Company findById(Integer id);
	
	public Company save(Company company);
}
