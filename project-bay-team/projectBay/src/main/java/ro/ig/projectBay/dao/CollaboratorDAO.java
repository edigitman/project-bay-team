package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Collaborator;

public interface CollaboratorDAO extends JpaRepository<Collaborator, Integer> {

	static final String GET_COLLABORATOR_BY_COMPANY_ID = "select c from Collaborator c where c.company.id = :id";

	@Query(GET_COLLABORATOR_BY_COMPANY_ID)
	public List<Collaborator> getCollaboratorsByCompanyId(
			@Param("id") Integer id);

}
