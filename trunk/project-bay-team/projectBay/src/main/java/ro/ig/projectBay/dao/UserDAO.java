package ro.ig.projectBay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.ig.projectBay.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO extends JpaRepository<User, String> {

	public User findByEmail(String inputUsername);

}
