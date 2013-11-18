package ro.ig.projectBay.service.impl;

import javax.inject.Named;

import ro.ig.projectBay.service.UserService;

@Named
public class UserServiceImpl implements UserService{

	private static final long serialVersionUID = 729223685098543439L;

	@Override
	public String printMessage() {
		return "hello from spring service";
	}

}
