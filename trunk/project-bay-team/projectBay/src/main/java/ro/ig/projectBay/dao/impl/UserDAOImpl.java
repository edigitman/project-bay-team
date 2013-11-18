package ro.ig.projectBay.dao.impl;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import ro.ig.projectBay.dao.UserDAO;
import ro.ig.projectBay.model.User;

@Repository
public class UserDAOImpl extends AbstractDAOImpl <User> implements UserDAO {
	
	@PersistenceContext(name = "Project1", type = PersistenceContextType.TRANSACTION)
	private EntityManager em;

	public User getUser(String inputUsername) {
		User u = new User();
		try {
			u = (User) em.createNamedQuery("User.findUsername")
					.setParameter("username", inputUsername).getSingleResult();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		} catch (NonUniqueResultException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}
	
	public User getUserFromSession()
	{
		FacesContext fc = FacesContext.getCurrentInstance();
		return (User) fc.getExternalContext().getSessionMap().get("username");
	}

}
