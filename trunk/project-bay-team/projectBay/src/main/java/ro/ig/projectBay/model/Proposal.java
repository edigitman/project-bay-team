package ro.ig.projectBay.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The Class Proposal.
 */
@SuppressWarnings("serial")
@Entity(name = "proposal")
@NamedQueries({
		@NamedQuery(name = "findAllPropositions", query = "select p from proposal p"), })
public class Proposal implements Serializable{

	/** The id proposal. */
	@Id
	@GeneratedValue
	private long idProposal;
	
	/** The business id. */
	@Column(length = 10, unique = true)
	private String businessId;
	
	/** The start date. */
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	/** The end date. */
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	/** The validated. */
	@Column
	private boolean validated;
	
	/** The client. */
	@Column
	private String client;
	
	/** The project name. */
	@Column
	private String projectName;
	
	/** The description. */
	@Column
	private String description;

	/** The user object. */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private User userObject;
	
	/** The response object. */
	@OneToMany(mappedBy = "proposalObject")
	private List<Response> responseObject;

	/**
	 * Gets the id proposal.
	 *
	 * @return the id proposal
	 */
	public long getIdProposal() {
		return idProposal;
	}

	/**
	 * Sets the id proposal.
	 *
	 * @param idProposal the new id proposal
	 */
	public void setIdProposal(long idProposal) {
		this.idProposal = idProposal;
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
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * Gets the client.
	 *
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * Sets the client.
	 *
	 * @param client the new client
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * Gets the project name.
	 *
	 * @return the project name
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * Sets the project name.
	 *
	 * @param projectName the new project name
	 */
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * Gets the response object.
	 *
	 * @return the response object
	 */
	public List<Response> getResponseObject() {
		return responseObject;
	}

	/**
	 * Sets the response object.
	 *
	 * @param responseObject the new response object
	 */
	public void setResponseObject(List<Response> responseObject) {
		this.responseObject = responseObject;
	}


}
