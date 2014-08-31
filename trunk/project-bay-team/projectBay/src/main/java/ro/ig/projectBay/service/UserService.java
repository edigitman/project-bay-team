package ro.ig.projectBay.service;

import java.io.Serializable;
import java.util.List;

import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;

public interface UserService extends Serializable {

	String printMessage();

	User findByEmail(String inputUsername);

	public User getCurrentUser();

	public void setCurrentUser(User currentUser);

	public User findByLogin(String login);

	public List<Role> getUserRoleForUser(Integer userId);
	
	public List<String> getUserTypeChoiceList();
	
	public User saveUser(User user);

}
