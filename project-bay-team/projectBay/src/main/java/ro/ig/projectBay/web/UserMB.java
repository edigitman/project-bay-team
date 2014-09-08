package ro.ig.projectBay.web;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "userMB")
@SessionScoped
public class UserMB implements Serializable {

	private static final long serialVersionUID = -3990573210489057318L;

	private static final Logger logger = LoggerFactory.getLogger(UserMB.class);

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	private String username;
	private String password;

	@PostConstruct
	public void init() {
		username = new String();
		password = new String();
	}

	public String doLogin() throws ServletException, IOException {
		// do any job with the associated values that you've got from the user,
		// like persisting attempted login, etc.
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext extenalContext = facesContext.getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) extenalContext
				.getRequest()).getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) extenalContext.getRequest(),
				(ServletResponse) extenalContext.getResponse());
		facesContext.responseComplete();
		return null;
	}

	public String printMsgFromSpring() {
		return userService.printMessage();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public boolean isUserLoggedIn() {
		boolean userLogged = userService.getCurrentUser() != null;
		logger.debug("Is user logedIn returned [{}]", userLogged);
		return userLogged;
	}

	public void logout() {
		userService.setCurrentUser(null);
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
