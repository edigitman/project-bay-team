package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Response;

public interface ResponseDAO extends JpaRepository<Response, Integer> {

	static final String GET_RESPONSE_BY_PROJECT = "select r from Response r where r.project.id = :idProject";

	@Query(GET_RESPONSE_BY_PROJECT)
	public List<Response> getResponseByProject(@Param("idProject") Integer id);
}
