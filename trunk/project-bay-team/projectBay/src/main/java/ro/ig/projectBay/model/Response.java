package ro.ig.projectBay.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


/**
 * The Class Response.
 */
@SuppressWarnings("serial")
@Entity(name = "response")
@NamedQueries({
		@NamedQuery(name = "findAllResponses", query = "select r from response r"), })
public class Response implements Serializable {

	/**
	 * The response's ID in the database.
	 */
	@Id
	@GeneratedValue
	private int idResponse;

	/**
	 * The business id.
	 */
	@Column(length = 10, unique = true)
	private String businessId;

	/**
	 * The agency the response refers to.
	 */
	@Column
	private String agency;

	/**
	 * The actual text response.
	 */
	@Column
	private String response;

	/**
	 * The proposed price by the response.
	 */
	@Column
	private double price;
	
	/**
	 * The validation status for the response.
	 */
	@Column
	private boolean validated;
	
	/**
	 * The refused status for the response.
	 */
	@Column
	private boolean refused;

	/**
	 * The collaborators proposed in the response.
	 */
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "belong", joinColumns = @JoinColumn(name = "idResponse"), inverseJoinColumns = @JoinColumn(name = "idCollaborator"))
	private List<Collaborator> collaboratorList;

	/**
	 * The user who wrote the response.
	 */
	@ManyToOne
	private User userObject;

	/**
	 * The proposal for which the response was written.
	 */
	@ManyToOne
	private Proposal proposalObject;

	/**
	 * Default constructor.
	 */
	public Response() {
		super();
	}

	/**
	 * Gets the id response.
	 *
	 * @return the id response
	 */
	public int getIdResponse() {
		return idResponse;
	}

	/**
	 * Sets the id response.
	 *
	 * @param idResponse the new id response
	 */
	public void setIdResponse(int idResponse) {
		this.idResponse = idResponse;
	}

	/**
	 * Gets the business id.
	 *
	 * @return the business id
	 */
	public String getBusinessId() {
		return businessId;
	}

	/**
	 * Sets the business id.
	 *
	 * @param businessId the new business id
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * Gets the agency.
	 *
	 * @return the agency
	 */
	public String getAgency() {
		return agency;
	}

	/**
	 * Sets the agency.
	 *
	 * @param agency the new agency
	 */
	public void setAgency(String agency) {
		this.agency = agency;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public String getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(String response) {
		this.response = response;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Checks if is validated.
	 *
	 * @return true, if is validated
	 */
	public boolean isValidated() {
		return validated;
	}

	/**
	 * Sets the validated.
	 *
	 * @param validated the new validated
	 */
	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	/**
	 * Checks if is refused.
	 *
	 * @return true, if is refused
	 */
	public boolean isRefused() {
		return refused;
	}

	/**
	 * Sets the refused.
	 *
	 * @param refused the new refused
	 */
	public void setRefused(boolean refused) {
		this.refused = refused;
	}

	/**
	 * Gets the collaborator list.
	 *
	 * @return the collaborator list
	 */
	public List<Collaborator> getCollaboratorList() {
		return collaboratorList;
	}

	/**
	 * Sets the collaborator list.
	 *
	 * @param collaboratorList the new collaborator list
	 */
	public void setCollaboratorList(List<Collaborator> collaboratorList) {
		this.collaboratorList = collaboratorList;
	}

	/**
	 * Gets the user object.
	 *
	 * @return the user object
	 */
	public User getUserObject() {
		return userObject;
	}

	/**
	 * Sets the user object.
	 *
	 * @param userObject the new user object
	 */
	public void setUserObject(User userObject) {
		this.userObject = userObject;
	}

	/**
	 * Gets the proposal object.
	 *
	 * @return the proposal object
	 */
	public Proposal getProposalObject() {
		return proposalObject;
	}

	/**
	 * Sets the proposal object.
	 *
	 * @param proposalObject the new proposal object
	 */
	public void setProposalObject(Proposal proposalObject) {
		this.proposalObject = proposalObject;
	}

}
