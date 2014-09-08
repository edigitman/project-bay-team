package ro.ig.projectBay.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;

public interface UserService extends Serializable {

	String printMessage();

	User findByEmail(String inputUsername);

	User getCurrentUser();

	void setCurrentUser(User currentUser);

	User findByLogin(String login);

	List<Role> getUserRoleForUser(Integer userId);

	List<String> getUserTypeChoiceList();

	User saveUser(User user);

	Map<String, String> getUserTypeMap();

	List<User> getNumberOfClients();

	List<User> getNumberOfDAs();

}
