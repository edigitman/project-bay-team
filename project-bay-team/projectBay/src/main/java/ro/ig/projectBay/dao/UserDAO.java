package ro.ig.projectBay.dao;

import ro.ig.projectBay.model.User;

public interface UserDAO extends AbstractDAO<User> {
	public User getUser(String inputUsername);
	public User getUserFromSession();
}
