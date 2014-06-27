package ro.ig.projectBay.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String title;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Lob
	private String description;

	@Column
	private int validated;

	@Lob
	private byte[] documentation;
	@Column
	private Double price;

	@ManyToMany
	@JoinTable(name = "user_project_clearance", joinColumns = @JoinColumn(name = "idProject"), inverseJoinColumns = @JoinColumn(name = "idUser"))
	private List<User> usersCleared;

	@ManyToOne
	private User client;

	@OneToMany(mappedBy = "project")
	private List<Response> responses;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int isValidated() {
		return validated;
	}

	public void setValidated(int validated) {
		this.validated = validated;
	}

	public byte[] getDocumentation() {
		return documentation;
	}

	public void setDocumentation(byte[] documentation) {
		this.documentation = documentation;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<User> getUsersCleared() {
		return usersCleared;
	}

	public void setUsersCleared(List<User> usersCleared) {
		this.usersCleared = usersCleared;
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public List<Response> getResponses() {
		return responses;
	}

	public void setResponses(List<Response> responses) {
		this.responses = responses;
	}

}