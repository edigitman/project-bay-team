package ro.ig.projectBay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * The Class User.
 */
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUser;
	@Column
	private String email;

	@Column
	private String password;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(name = "active", columnDefinition = "bit")
	private boolean active;

	@OneToMany(mappedBy = "userObject")
	private List<Response> responsesList;

	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles;
	
	@OneToMany(mappedBy="employees")
	private Company employer;

	@ManyToOne
	private List<EmailLog> emailReceived;

	@ManyToOne
	private List<EmailLog> emailSent;

	@ManyToMany(mappedBy = "usersCleared")
	private List<Project> projectsCleared;

	@ManyToOne
	@JoinTable(name = "projects_proposed", joinColumns = @JoinColumn(name = "idUser"), inverseJoinColumns = @JoinColumn(name = "idProject"))
	private List<Project> projectsProposed;

	@Lob
	@Column
	private byte[] cv;

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Response> getResponsesList() {
		return responsesList;
	}

	public void setResponsesList(List<Response> responsesList) {
		this.responsesList = responsesList;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

	public List<EmailLog> getEmailReceived() {
		return emailReceived;
	}

	public void setEmailReceived(List<EmailLog> emailReceived) {
		this.emailReceived = emailReceived;
	}

	public List<EmailLog> getEmailSent() {
		return emailSent;
	}

	public void setEmailSent(List<EmailLog> emailSent) {
		this.emailSent = emailSent;
	}

	public List<Project> getProjectsCleared() {
		return projectsCleared;
	}

	public void setProjectsCleared(List<Project> projectsCleared) {
		this.projectsCleared = projectsCleared;
	}

	public List<Project> getProjectsProposed() {
		return projectsProposed;
	}

	public void setProjectsProposed(List<Project> projectsProposed) {
		this.projectsProposed = projectsProposed;
	}

	public byte[] getCv() {
		return cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

}
