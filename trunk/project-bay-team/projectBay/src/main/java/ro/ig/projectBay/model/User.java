package ro.ig.projectBay.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * The Class User.
 */
@SuppressWarnings("serial")
@Entity(name = "user")
@NamedQueries({
		@NamedQuery(name = "User.findUserById", query = "select u from user u where u.idUser= :id"),
		@NamedQuery(name = "User.findAllUsers", query = "select u from user u"),
		@NamedQuery(name = "User.findUserByEmail", query = "select u from user u where u.email = :email"),
		@NamedQuery(name = "User.findUserByEmailAndPassword", query = "select u from user u where u.email = :email and u.password = :password") })
public class User implements Serializable {

	/**
	 * The user's ID in the database.
	 */
	@Id
	@GeneratedValue
	private long idUser;

	/**
	 * The business id.
	 */
	@Column(length = 10, unique = true)
	private String businessId;

	/**
	 * User email.
	 */
	@Column
	private String email;

	/**
	 * User password.
	 */
	@Column
	private String password;

	/**
	 * User first name.
	 */
	@Column
	private String firstName;

	/**
	 * User last name.
	 */
	@Column
	private String lastName;

	/**
	 * Set of rights.
	 */
	@Column
	private String rights;

	/**
	 * The list of responses that a user has wrote.
	 */

	@OneToMany(mappedBy = "userObject")
	private List<Response> responsesList;

	/**
	 * The list of proposal that the user has wrote.
	 */

	@OneToMany(mappedBy = "userObject")
	private List<Proposal> proposalList;

	/**
	 * The user's cv.
	 */
	@Lob
	@Column
	private String cv;

	/**
	 * Default constructor.
	 */
	public User() {
		super();
	}

	/**
	 * Gets the id user.
	 * 
	 * @return the id user
	 */
	public long getIdUser() {
		return idUser;
	}

	/**
	 * Sets the id user.
	 * 
	 * @param idUser
	 *            the new id user
	 */
	public void setIdUser(long idUser) {
		this.idUser = idUser;
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
	 * @param businessId
	 *            the new business id
	 */
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	/**
	 * Gets the email.
	 * 
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 * 
	 * @param email
	 *            the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the password.
	 * 
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name.
	 * 
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 * 
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 * 
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 * 
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the rights.
	 * 
	 * @return the rights
	 */
	public String getRights() {
		return rights;
	}

	/**
	 * Sets the rights.
	 * 
	 * @param rights
	 *            the new rights
	 */
	public void setRights(String rights) {
		this.rights = rights;
	}

	/**
	 * Gets the reponses list.
	 * 
	 * @return the reponses list
	 */
	public List<Response> getResponsesList() {
		return responsesList;
	}

	/**
	 * Sets the reponses list.
	 * 
	 * @param responsesList
	 *            the new reponses list
	 */
	public void setResponsesList(List<Response> responsesList) {
		this.responsesList = responsesList;
	}

	/**
	 * Gets the propositions list.
	 * 
	 * @return the propositions list
	 */
	public List<Proposal> getProposalList() {
		return proposalList;
	}

	/**
	 * Sets the propositions list.
	 * 
	 * @param proposalList
	 *            the new propositions list
	 */
	public void setProposalList(List<Proposal> proposalList) {
		this.proposalList = proposalList;
	}

	/**
	 * Gets the cv.
	 * 
	 * @return the cv
	 */
	public String getCv() {
		return cv;
	}

	/**
	 * Sets the cv.
	 * 
	 * @param cv
	 *            the new cv
	 */
	public void setCv(String cv) {
		this.cv = cv;
	}

}
