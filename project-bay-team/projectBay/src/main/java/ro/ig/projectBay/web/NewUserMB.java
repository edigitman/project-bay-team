package ro.ig.projectBay.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "newUserMB")
@RequestScoped
public class NewUserMB {

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private User newUser;
	private List<String> userTypeChoiceList;
	private String userTypeChosen;
	private String pass1;
	private String pass2;
	@PostConstruct
	public void init() {
		newUser = new User();
		userTypeChosen = new String();
		pass1=new String();
		pass2=new String();
		userTypeChoiceList = userService.getUserTypeChoiceList();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public List<String> getUserTypeChoiceList() {
		return userTypeChoiceList;
	}

	public void setUserTypeChoiceList(List<String> userTypeChoiceList) {
		this.userTypeChoiceList = userTypeChoiceList;
	}

	public String getUserTypeChosen() {
		return userTypeChosen;
	}

	public void setUserTypeChosen(String userTypeChosen) {
		this.userTypeChosen = userTypeChosen;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

}
