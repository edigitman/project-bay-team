package ro.ig.projectBay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.UserDAO;
import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.UserService;

@Service(value = "userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 729223685098543439L;
	
	private User currentUser;

	@Autowired
	private UserDAO userDAO;

	public String printMessage() {
		return "hello from spring service";
	}

	@Override
	public User findByEmail(String inputUsername) {
		return userDAO.findByEmail(inputUsername);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
