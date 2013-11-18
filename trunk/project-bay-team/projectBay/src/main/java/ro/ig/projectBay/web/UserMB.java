package ro.ig.projectBay.web;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.context.annotation.Scope;

import ro.ig.projectBay.service.UserService;

@Named
@Scope("session")
public class UserMB implements Serializable {

	private static final long serialVersionUID = -3990573210489057318L;

	@Inject
	private UserService userService;

	private String username;
	private String password;

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

	public String printMsgFromSpring() {
		return userService.printMessage();
	}

	public boolean isUserLoggedIn() {
		return false;
	}
}
