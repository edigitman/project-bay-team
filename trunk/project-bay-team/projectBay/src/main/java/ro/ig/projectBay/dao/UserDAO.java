package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO extends JpaRepository<User, String> {

	static final String GET_USER_ROLE_FOR_USER = "select u.roleList from User u where u.id = :userId";
	static final String GET_NUMBER_OF_USERS = "select r.users from Role r where r.code = :roleCode";

	public User findByEmail(String inputUsername);

	public User findByLogin(String login);

	@Query(GET_USER_ROLE_FOR_USER)
	public List<Role> getUserRoleForUser(@Param("userId") Integer userId);

	@Query(GET_NUMBER_OF_USERS)
	public List<User> getNumberOfUsersWithRole(@Param("roleCode") String roleCode);

}
