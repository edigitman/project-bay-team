package ro.ig.projectBay.enitityTesting;

import javax.persistence.EntityManager;

import junit.framework.TestCase;

import org.junit.Test;

import ro.ig.projectBay.model.Proposal;
import ro.ig.projectBay.model.Response;
import ro.ig.projectBay.model.User;

public class ResponseTest extends TestCase {
	private EntityManager em = PersistenceHelper.getInstance().getEm();

	public ResponseTest(String testName) {
		super(testName);
	}

	@Test
	public void testCrud() {
		// create
		Response response = createResponse1();
		assertNotNull(response);
		addResponse(response);
		assertEquals(true, response.isValidated());
		long id = response.getIdResponse();
		// read
		try {
			response = readResponse(id);
			assertNotNull(response);
			assertEquals(true, response.isValidated());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// update
		response = updateResponse(id);
		assertNotNull(response);
		assertEquals(false, response.isValidated());
		// delete
		// deleteResponse(response);

		em.close();
	}

	private void addResponse(Response response) {
		em.getTransaction().begin();
		em.persist(response);
		em.getTransaction().commit();
	}

	private Response readResponse(long id) {
		em.getTransaction().begin();
		Response response = em.find(Response.class, id);
		em.getTransaction().commit();
		return response;
	}

	private Response updateResponse(long id) {
		em.getTransaction().begin();

		Response response = em.find(Response.class, id);
		response.setValidated(false);

		response = em.merge(response);
		em.getTransaction().commit();
		return response;
	}

	private void deleteResponse(Response response) {
		em.getTransaction().begin();
		em.remove(response);
		em.getTransaction().commit();
	}

	private Response createResponse1() {
		Response response = new Response();
		//TODO: response
		response.setAgency("IAS");
		response.setBusinessId("kdo2");
		//response.se
		return response;
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
