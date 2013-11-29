package ro.ig.projectBay.enitityTesting;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Test;

import ro.ig.projectBay.model.User;

public class UserTest extends TestCase {

	private EntityManager em = PersistenceHelper
			.getInstance().getEm();

	public UserTest(String testName) {
		super(testName);
	}

	@Test
	public void testCrud() {
		// create
		User user = createUser1();
		assertNotNull(user);
		addUser(user);
		assertEquals("ioana.ioana@ioana.ioana", user.getEmail());
		long id = user.getIdUser();
		// read
		try {
			user = readUser(id);
			assertNotNull(user);
			assertEquals("ioana.ioana@ioana.ioana", user.getEmail());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// update
		user=updateUser(id);
		assertNotNull(user);
		assertEquals("ioana.ioana@ioana.com", user.getEmail());
		// delete
		//deleteUser(user);
		
		em.close();
	}

	private void addUser(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}

	private User readUser(long id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		return user;
	}

	private User updateUser(long id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		user.setEmail("ioana.ioana@ioana.com");
		user = em.merge(user);
		em.getTransaction().commit();
		return user;
	}

	private void deleteUser(User user) {
		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();
	}

	private User createUser1() {
		User user = new User();
		user.setBusinessId("IAS");
		user.setEmail("ioana.ioana@ioana.ioana");
		user.setFirstName("Ioana");
		user.setLastName("Apostol");
		user.setPassword("1234");
		user.setRights("USER");
		return user;
	}
}
