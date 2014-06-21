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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "project")
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idProject;

	@Column
	private String title;

	@Temporal(TemporalType.DATE)
	private Date startDate;

	@Temporal(TemporalType.DATE)
	private Date endDate;

	@Lob
	private String description;

	@Column
	private boolean validated;

	@Lob
	private byte[] documentation;
	@Column
	private Double price;

	@ManyToMany
	@JoinTable(name = "user_project_clearance", joinColumns = @JoinColumn(name = "idProject"), inverseJoinColumns = @JoinColumn(name = "idUser"))
	private List<User> usersCleared;

	@OneToMany(mappedBy = "projectsProposed")
	private User client;

	@OneToMany(mappedBy = "project")
	private List<Response> responses;
}
