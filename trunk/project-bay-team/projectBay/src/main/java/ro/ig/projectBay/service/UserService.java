package ro.ig.projectBay.service;

import java.io.Serializable;

import ro.ig.projectBay.model.User;

public interface UserService extends Serializable {

	String printMessage();

	User findByEmail(String inputUsername);

	public User getCurrentUser();

	public void setCurrentUser(User currentUser);
}
