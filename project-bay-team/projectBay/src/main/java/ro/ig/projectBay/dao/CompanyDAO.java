package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ro.ig.projectBay.model.Company;

public interface CompanyDAO extends JpaRepository<Company, Integer> {

	static final String GET_ALL_COMPANIES = "select c from Company c ";

	@Query(GET_ALL_COMPANIES)
	public List<Company> findAll();

	public Company findById(Integer id);
}
