package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectDAO extends JpaRepository<Project, String> {

	static final String GET_PROJECTS_BY_USER_CLEARED = "select p from Project p where :user in p.usersCleared";

	public List<Project> findByClient(User client);

	@Query(GET_PROJECTS_BY_USER_CLEARED)
	public List<Project> getProjectsByUserCleared(@Param("user") User userDA);
}
