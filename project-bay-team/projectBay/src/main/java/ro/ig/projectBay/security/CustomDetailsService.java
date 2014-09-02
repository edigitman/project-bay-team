package ro.ig.projectBay.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.UserService;

@Component
public class CustomDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(CustomDetailsService.class);
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		
		User user = null;
		CustomUserDetails userDetails = null;

		try {
			user = userService.findByLogin(username);
			/*List<String> ur = userService.getUserRoleForUser(user.getId());
			userService.setCurrentUsersRoles(ur);*/
			userService.setCurrentUser(user);
			userDetails = new CustomUserDetails(user);

		} catch (Exception e) {
			logger.debug(e.getMessage(), e);
		}

		return userDetails;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
