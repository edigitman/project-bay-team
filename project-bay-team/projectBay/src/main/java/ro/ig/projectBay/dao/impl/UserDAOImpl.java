package ro.ig.projectBay.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;

import ro.ig.projectBay.dao.UserDAO;
import ro.ig.projectBay.model.User;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User> implements UserDAO {

	public User findByEmail(String inputUsername) {
		User u = new User();
		try {
			u =
					(User) em.createNamedQuery("User.findUserByEmail").setParameter("email", inputUsername)
							.getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		} catch (NonUniqueResultException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

}
