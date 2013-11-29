package ro.ig.projectBay.enitityTesting;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Test;

import ro.ig.projectBay.model.Proposal;
import ro.ig.projectBay.model.User;

public class ProposalTest extends TestCase {

	private EntityManager em = PersistenceHelper.getInstance().getEm();

	public ProposalTest(String testName) {
		super(testName);
	}

	@Test
	public void testCrud() {
		// create
		Proposal proposal = createProposal1();
		assertNotNull(proposal);
		addProposal(proposal);
		assertEquals(true, proposal.isValidated());
		long id = proposal.getIdProposal();
		// read
		try {
			proposal = readProposal(id);
			assertNotNull(proposal);
			assertEquals(true, proposal.isValidated());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// update
		proposal = updateProposal(id);
		assertNotNull(proposal);
		assertEquals(false, proposal.isValidated());
		// delete
		// deleteProposal(proposal);

		em.close();
	}

	private void addProposal(Proposal proposal) {
		em.getTransaction().begin();
		em.persist(proposal);
		em.getTransaction().commit();
	}

	private Proposal readProposal(long id) {
		em.getTransaction().begin();
		Proposal proposal = em.find(Proposal.class, id);
		em.getTransaction().commit();
		return proposal;
	}

	private Proposal updateProposal(long id) {
		em.getTransaction().begin();

		Proposal proposal = em.find(Proposal.class, id);
		proposal.setValidated(false);

		proposal = em.merge(proposal);
		em.getTransaction().commit();
		return proposal;
	}

	private void deleteProposal(Proposal proposal) {
		em.getTransaction().begin();
		em.remove(proposal);
		em.getTransaction().commit();
	}

	private Proposal createProposal1() {
		Proposal proposal = new Proposal();

		GregorianCalendar c1 = new GregorianCalendar(2000, 7, 15);
		GregorianCalendar c2 = new GregorianCalendar(2013, 7, 15);

		proposal.setBusinessId("dfol3");
		proposal.setClient("Client name");
		proposal.setDescription("Proposal description");
		proposal.setStartDate(c1.getTime());
		proposal.setEndDate(c2.getTime());
		proposal.setProjectName("Name");
		proposal.setUserObject(readUser(1));
		proposal.setValidated(true);
		return proposal;
	}

	private User readUser(long id) {
		em.getTransaction().begin();
		User user = em.find(User.class, id);
		em.getTransaction().commit();
		return user;
	}
}
