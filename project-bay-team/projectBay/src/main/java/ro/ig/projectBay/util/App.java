package ro.ig.projectBay.util;

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
		em.getTransaction().commit();
	}
}
