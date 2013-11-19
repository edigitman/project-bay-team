package ro.ig.projectBay.enitityTesting;

import ro.ig.projectBay.model.User;
import junit.framework.TestCase;

public class UserTest extends TestCase {

	private javax.persistence.EntityManager em = PersistenceHelper
			.getInstance().getEm();

	public UserTest(String testName) {
		super(testName);
	}

	public void crudTest() {

		em.close();
	}

	private void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	private User readUser(int id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		return user;
	}

	private User updateUser(int id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		user.setEmail("ioana.ioana@ioana.com");
		user = em.merge(user);
		em.getTransaction().commit();
		return user;
	}

	private void deleteUser(User user) {

	}

	private User createUser1() {
		User user = new User();
		user.setBusinessId("aaa");
		user.setEmail("ioana.ioana@ioana.ioana");
		user.setFirstName("Ioana");
		user.setLastName("Apostol");
		user.setPassword("1234");
		user.setRights("USER");
		return user;
	}
}
