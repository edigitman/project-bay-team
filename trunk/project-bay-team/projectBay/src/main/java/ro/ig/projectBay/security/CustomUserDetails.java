package ro.ig.projectBay.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

import ro.ig.projectBay.model.User;


public class CustomUserDetails implements UserDetails{

	private static final long serialVersionUID = 3026412236300362357L;
	
	private User user;
	
	public CustomUserDetails(User user) {
		this.user = user;
	}
	
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new GrantedAuthorityImpl("USER") );
		
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

}
