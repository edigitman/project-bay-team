package ro.ig.projectBay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class User.
 */
@Entity(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String email;

	@Column
	private String password;

	@Column(name = "txt_login")
	private String login;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(name = "active", columnDefinition = "bit")
	private int active;

	@OneToMany(mappedBy = "responseAuthor")
	private List<Response> responsesList;

	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles;

	@OneToOne
	private Company employer;

	/*
	 * @ManyToOne private List<EmailLog> emailReceived;
	 * 
	 * @ManyToOne private List<EmailLog> emailSent;
	 */

	@ManyToMany(mappedBy = "usersCleared")
	private List<Project> projectsCleared;

	@OneToMany(mappedBy = "client")
	private List<Project> projectsProposed;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int isActive() {
		return active;
	}

	public void setActive(int active) {
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}