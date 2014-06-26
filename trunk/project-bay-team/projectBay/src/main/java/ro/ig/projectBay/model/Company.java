package ro.ig.projectBay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String url;
	@Column
	private String cui;
	@OneToOne
	private User da;
	@OneToMany(mappedBy = "company")
	private List<Collaborator> employeeList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getDa() {
		return da;
	}

	public void setDa(User da) {
		this.da = da;
	}

	public List<Collaborator> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Collaborator> employeeList) {
		this.employeeList = employeeList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCui() {
		return cui;
	}

	public void setCui(String cui) {
		this.cui = cui;
	}

}