package ro.ig.projectBay.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	private Map<String, String> userTypeMap;

	@Autowired
	private UserDAO userDAO;

	@PostConstruct
	public void init() {
		currentUser = null;
		userTypeChoiceList = new ArrayList<String>();
		userTypeChoiceList.add("Customer User");
		userTypeChoiceList.add("IT Company Representant User");
		userTypeMap = new HashMap<String, String>();
		userTypeMap.put("Customer User", "CLIENT");
		userTypeMap.put("IT Company Representant User", "DA");
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

	@Transactional(readOnly = false)
	public User saveUser(User user) {
		return userDAO.saveAndFlush(user);
	}

	public List<String> getUserTypeChoiceList() {
		return userTypeChoiceList;
	}

	public Map<String, String> getUserTypeMap() {
		return userTypeMap;
	}

	@Override
	public List<User> getNumberOfClients() {
		return userDAO.getNumberOfUsersWithRole("CLIENT");
	}

	@Override
	public List<User> getNumberOfDAs() {
		return userDAO.getNumberOfUsersWithRole("DA");
	}

}
