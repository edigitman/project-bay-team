package ro.ig.projectBay.util;

import java.util.ArrayList;
import java.util.List;

import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;

public class App {
	private String PERSISTENCE_UNIT_NAME = "auctionHouse";
	private javax.persistence.EntityManagerFactory emf;
	private javax.persistence.EntityManager em;

	public static void main(String[] args) {
		System.out.println("Ignore the warnings: ");
		App hello = new App();
		hello.initEntityManager();
		hello.create();
		System.out.println("em created");

		hello.newUser();
		
		hello.commit();
		hello.closeEntityManager();
		System.out.println("em closed");
	}

	private void initEntityManager() {
		emf = javax.persistence.Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	private void closeEntityManager() {
		em.close();
		emf.close();
	}

	private void create() {
		em.getTransaction().begin();

	}

	private void newUser() {
		Role r = new Role();
		r.setCode("CLIENT");
		r.setId(1);
		r = em.merge(r);

		List<Role> rl = new ArrayList<Role>();
		rl.add(r);
		User u = new User();
		u.setId(1);
		u.setActive(1);
		u.setLogin("b");
		u.setPassword("b");
		u.setRoleList(rl);
		em.merge(u);

	}

	private void commit() {
		em.getTransaction().commit();
	}

}
