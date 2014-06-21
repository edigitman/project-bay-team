package ro.ig.projectBay.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * The Class Response.
 */
@SuppressWarnings("serial")
@Entity(name = "response")
public class Response implements Serializable {

	/**
	 * The response's ID in the database.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAnswer;

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
	private boolean denied;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinTable(name = "answer", joinColumns = @JoinColumn(name = "idAnswer"), inverseJoinColumns = @JoinColumn(name = "idUser"))
	private List<User> users;

	@ManyToOne
	private User userObject;

	/**
	 * The proposal for which the response was written.
	 */
	@ManyToOne
	private Project project;

}
