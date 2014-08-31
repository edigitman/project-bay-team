package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectDAO extends JpaRepository<Project, String> {

	public static final String GET_PAST_PROJECTS = "select p from Project p where p.validated = 1 and p.client.id = :clientid";

	public List<Project> findByClient(User client);

	@Query(GET_PAST_PROJECTS)
	public List<Project> findPastProjects(@Param("clientid") Integer id);

}
