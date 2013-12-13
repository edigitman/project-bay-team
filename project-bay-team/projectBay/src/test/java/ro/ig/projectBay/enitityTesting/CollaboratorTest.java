package ro.ig.projectBay.enitityTesting;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Test;

import ro.ig.projectBay.model.Proposal;
import ro.ig.projectBay.model.Collaborator;
import ro.ig.projectBay.model.User;

public class CollaboratorTest extends TestCase {
	private EntityManager em = PersistenceHelper.getInstance().getEm();

	public CollaboratorTest(String testName) {
		super(testName);
	}

	@Test
	public void testCrud() {
		// create
		Collaborator collaborator = createCollaborator1();
		assertNotNull(collaborator);
		addCollaborator(collaborator);
		//assertEquals(true, collaborator.isValidated());
		//long id = collaborator.g();
		// read
		try {
			//collaborator = readCollaborator(id);
			assertNotNull(collaborator);
			//assertEquals(true, collaborator.isValidated());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// update
		//collaborator = updateCollaborator(id);
		assertNotNull(collaborator);
		//assertEquals(false, collaborator.isValidated());
		// delete
		// deleteCollaborator(collaborator);

		//em.close();
	}

	private void addCollaborator(Collaborator collaborator) {
		em.getTransaction().begin();
		em.persist(collaborator);
		em.getTransaction().commit();
	}

	private Collaborator readCollaborator(long id) {
		em.getTransaction().begin();
		Collaborator collaborator = em.find(Collaborator.class, id);
		em.getTransaction().commit();
		return collaborator;
	}

	private Collaborator updateCollaborator(long id) {
		em.getTransaction().begin();

		Collaborator collaborator = em.find(Collaborator.class, id);
		//collaborator.setValidated(false);

		collaborator = em.merge(collaborator);
		em.getTransaction().commit();
		return collaborator;
	}

	private void deleteCollaborator(Collaborator collaborator) {
		em.getTransaction().begin();
		em.remove(collaborator);
		em.getTransaction().commit();
	}

	private Collaborator createCollaborator1() {
		Collaborator collaborator = new Collaborator();
		//TODO: collaborator
		collaborator.setAgency("IAS");
		collaborator.setBusinessId("kdo2");
		
		return collaborator;
	}

	private User readUser(long id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		return user;
	}

	private Proposal readProposal(long id) {
		em.getTransaction().begin();
		Proposal proposal = em.find(Proposal.class, id);
		em.getTransaction().commit();
		return proposal;
	}

}
