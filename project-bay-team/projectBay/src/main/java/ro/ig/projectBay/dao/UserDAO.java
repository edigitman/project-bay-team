package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO extends JpaRepository<User, String> {

	static final String GET_PROJECTS_BY_USER_CLEARED = "select u from User u where u.id = :userId";

	public User findByEmail(String inputUsername);

	@Query(GET_PROJECTS_BY_USER_CLEARED)
	public List<Project> getProjectsByUserCleared(@Param("userId") Integer id);

}
