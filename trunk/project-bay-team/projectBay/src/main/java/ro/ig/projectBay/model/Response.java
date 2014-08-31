package ro.ig.projectBay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import ro.ig.projectBay.util.PersistenceListener;

/**
 * The Class Response.
 */
@Entity
@EntityListeners(PersistenceListener.class)
public class Response {

	/**
	 * The response's ID in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

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
	private int validated;

	/**
	 * The refused status for the response.
	 */
	@Column
	private int denied;

	@ManyToOne
	private User responseAuthor;

	@ManyToOne
	private Project project;

	@OneToMany(mappedBy = "response")
	private List<Collaborator> collaboratorsList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getValidated() {
		return validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	public int getDenied() {
		return denied;
	}

	public void setDenied(int denied) {
		this.denied = denied;
	}

	public User getResponseAuthor() {
		return responseAuthor;
	}

	public void setResponseAuthor(User responseAuthor) {
		this.responseAuthor = responseAuthor;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Collaborator> getCollaboratorsList() {
		return collaboratorsList;
	}

	public void setCollaboratorsList(List<Collaborator> collaboratorsList) {
		this.collaboratorsList = collaboratorsList;
	}

}