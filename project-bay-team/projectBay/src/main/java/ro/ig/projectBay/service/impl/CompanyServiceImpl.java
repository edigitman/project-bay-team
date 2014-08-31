package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.CompanyDAO;
import ro.ig.projectBay.model.Company;
import ro.ig.projectBay.service.CompanyService;

@Service(value = "companyService")
@Transactional(readOnly = true)
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyDAO companyDAO;

	public List<Company> findAll() {
		return companyDAO.findAll();
	}

	public Company findById(Integer id) {
		return companyDAO.findById(id);
	}

	public Company save(Company company) {
		return companyDAO.saveAndFlush(company);
	}
}
