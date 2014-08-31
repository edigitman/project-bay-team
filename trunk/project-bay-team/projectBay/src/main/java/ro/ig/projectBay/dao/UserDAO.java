package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO extends JpaRepository<User, String> {

	static final String GET_PROJECTS_BY_USER_CLEARED = "select u from User u where u.id = :userId";
	//static final String GET_USER_ROLE_FOR_USER = "select ur.role.code from UserRole ur where ur.user.id = :userId";
	static final String GET_USER_ROLE_FOR_USER="select u.roleList from User u where u.id = :userId";
	
	public User findByEmail(String inputUsername);

	@Query(GET_PROJECTS_BY_USER_CLEARED)
	public List<Project> getProjectsByUserCleared(@Param("userId") Integer id);

	public User findByLogin(String login);

	@Query(GET_USER_ROLE_FOR_USER)
	public List<Role> getUserRoleForUser(@Param("userId")Integer userId);
}