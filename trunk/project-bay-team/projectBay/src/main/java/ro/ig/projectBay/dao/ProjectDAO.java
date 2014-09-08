package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectDAO extends JpaRepository<Project, String> {

	static final String GET_PAST_PROJECTS = "select p from Project p where p.validated = 1 and p.client.id = :clientid";
	static final String GET_PROJECTS_BY_USER_CLEARED = "select u.projectsCleared from User u where u.id = :userId";
	static final String GET_WON_PROJECTS = "select r.project from Response r where r.responseAuthor = :userId and r.validated = 1";
	static final String GET_NUMBER_OF_PROJECTS_BY_VALIDITY = "select count(p) from Project p where p.validated = :validity";

	public List<Project> findByClient(User client);

	@Query(GET_PAST_PROJECTS)
	public List<Project> findPastProjects(@Param("clientid") Integer id);

	@Query(GET_PROJECTS_BY_USER_CLEARED)
	public List<Project> getProjectsByUserCleared(@Param("userId") Integer id);

	@Query(GET_WON_PROJECTS)
	public List<Project> getWonProjects(@Param("userId") Integer id);

	@Query(GET_NUMBER_OF_PROJECTS_BY_VALIDITY)
	public Integer getNumberOfProjectsByValidity(@Param("validity") int validity);
}
