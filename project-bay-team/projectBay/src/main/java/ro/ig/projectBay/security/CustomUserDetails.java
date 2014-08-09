package ro.ig.projectBay.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.UserService;

@Component
public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 3026412236300362357L;

	private User user;
	@Autowired
	private UserService userService;

	public CustomUserDetails() {
	}

	public CustomUserDetails(User user) {
		this.user = user;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Collection<GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> auth = new ArrayList<>();
		
	for (Role userRole : user.getRoleList()) {
			auth.add(new GrantedAuthorityImpl("ROLE_" + userRole.getCode()));
		}

		return auth;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
