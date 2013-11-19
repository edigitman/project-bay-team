package ro.ig.projectBay.dao;

import ro.ig.projectBay.model.User;

/**
 * The Interface UserDAO.
 */
public interface UserDAO extends AbstractDAO<User> {

	/**
	 * Find by user.
	 * 
	 * @param inputUsername
	 *            the input username
	 * @return the user
	 */
	User findByUser(String inputUsername);

}
