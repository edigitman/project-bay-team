package ro.ig.projectBay.security;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.model.User;

@Service
public class CustomDetailsService implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {

		User user = entityManager
				.createQuery("from user where email = :username", User.class)
				.setParameter("username", username).getSingleResult();

		CustomUserDetails userDetails = new CustomUserDetails(user);
		return userDetails;
	}
}
