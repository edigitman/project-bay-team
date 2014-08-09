package ro.ig.projectBay.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.UserDAO;
import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.UserService;

@Service(value = "userService")
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	private static final long serialVersionUID = 729223685098543439L;

	private User currentUser;
	private List<String> userTypeChoiceList;

	@Autowired
	private UserDAO userDAO;

	@PostConstruct
	public void init() {
		userTypeChoiceList = new ArrayList<String>();
		userTypeChoiceList.add("Customer User");
		userTypeChoiceList.add("IT Company Representant User");
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

	public User findByLogin(String login) {
		return userDAO.findByLogin(login);
	}

	public List<Role> getUserRoleForUser(Integer userId) {
		return userDAO.getUserRoleForUser(userId);
	}

	@Override
	public String printMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUserTypeChoiceList() {
		return userTypeChoiceList;
	}

	public void setUserTypeChoiceList(List<String> userTypeChoiceList) {
		this.userTypeChoiceList = userTypeChoiceList;
	}
	

}
