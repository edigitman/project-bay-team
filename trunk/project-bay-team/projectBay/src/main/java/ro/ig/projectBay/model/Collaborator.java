package ro.ig.projectBay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * The Class Collaborator.
 */
@Entity(name = "collaborator")
@NamedQueries({
		@NamedQuery(name = "findAllCollaborators", query = "SELECT c FROM collaborator c"),
		@NamedQuery(name = "findAllCollaboratorsById", query = "SELECT c FROM collaborator c WHERE c.idCollaborator = :idCollaborator"),
		@NamedQuery(name = "findCollaboratorsByAgency", query = "SELECT c FROM collaborator c WHERE c.agency = :agency"), })
public class Collaborator {

	/**
	 * The business id.
	 */
	@Column(length=10,unique=true)
	private String businessId;
	
	
	/**
	 * The collaborator id.
	 */
	@Id
	@GeneratedValue
	private int idCollaborator;
	
	
	/**
	 * The agency.
	 */
	@Column
	private String agency;
	
	
	/**
	 * The last name.
	 */
	@Column
	private String lastName;
	
	
	/**
	 * The first name.
	 */
	@Column
	private String firstName;
	
	
	/**
	 * The function.
	 */
	@Column
	private String function;
	
	
	/**
	 * The technology.
	 */
	@Column
	private String technology;
	
	
	/**
	 * The cv.
	 */
	@Lob
	private byte[] cv;
	
	/**
	 * The salary.
	 */
	@Column
	private double salary;

	/**
	 * The Responses list.
	 */
	@ManyToMany(mappedBy = "collaboratorList")
	private List<Response> ResponsesList;

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
	 * Gets the collaborator id.
	 *
	 * @return the collaborator id
	 */
	public int getCollaboratorId() {
		return idCollaborator;
	}

	/**
	 * Sets the collaborator id.
	 *
	 * @param collaboratorId the new collaborator id
	 */
	public void setCollaboratorId(int idCollaborator) {
		this.idCollaborator = idCollaborator;
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
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the function.
	 *
	 * @return the function
	 */
	public String getFunction() {
		return function;
	}

	/**
	 * Sets the function.
	 *
	 * @param function the new function
	 */
	public void setFunction(String function) {
		this.function = function;
	}

	/**
	 * Gets the technology.
	 *
	 * @return the technology
	 */
	public String getTechnology() {
		return technology;
	}

	/**
	 * Sets the technology.
	 *
	 * @param technology the new technology
	 */
	public void setTechnology(String technology) {
		this.technology = technology;
	}

	/**
	 * Gets the cv.
	 *
	 * @return the cv
	 */
	public byte[] getCv() {
		return cv;
	}

	/**
	 * Sets the cv.
	 *
	 * @param cv the new cv
	 */
	public void setCv(byte[] cv) {
		this.cv = cv;
	}

	/**
	 * Gets the salary.
	 *
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * Sets the salary.
	 *
	 * @param salary the new salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * Gets the responses list.
	 *
	 * @return the responses list
	 */
	public List<Response> getResponsesList() {
		return ResponsesList;
	}

	/**
	 * Sets the responses list.
	 *
	 * @param responsesList the new responses list
	 */
	public void setResponsesList(List<Response> responsesList) {
		ResponsesList = responsesList;
	}
	

}
