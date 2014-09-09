package ro.ig.projectBay.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.UserService;

//@FacesConverter(forClass = User.class, value = "userConverter")
@ManagedBean(name = "userConverter")
public class UserConverter implements Converter {

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		
		return userService.findByLogin(arg2);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		if (arg2 instanceof User) {
			User u = (User) arg2;
			return u.getLogin();
		}
		return null;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
