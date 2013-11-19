package ro.ig.projectBay.enitityTesting;

public class PersistenceHelper {
	
	private static PersistenceHelper instance;
	private javax.persistence.EntityManagerFactory emf;
	private javax.persistence.EntityManager em;
	private String PERSISTENCE_UNIT_NAME = "projectBay";

	public static PersistenceHelper getInstance() {
		if (instance == null) {
			instance = new PersistenceHelper();
		}
		return instance;
	}

	private PersistenceHelper() {
		initEntityManager();
	}

	private void initEntityManager() {
		emf = javax.persistence.Persistence
				.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = emf.createEntityManager();
	}

	public void closeEntityManager() {
		em.close();
		emf.close();
	}

	public javax.persistence.EntityManager getEm() {
		return em;
	}

	public static void main(String args[]) {
		getInstance().initEntityManager();
		System.out.println("done");

	}

}
