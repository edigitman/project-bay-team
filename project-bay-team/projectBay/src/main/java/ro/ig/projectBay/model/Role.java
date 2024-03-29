package ro.ig.projectBay.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import ro.ig.projectBay.util.PersistenceListener;

@Entity
@EntityListeners(PersistenceListener.class)
public class Role {

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	/**
	 * The txt_role_code.
	 */
	@Column
	private String code;

	/**
	 * The role name in English.
	 */
	@Column
	private String roleTitle;

	/**
	 * The user roles.
	 */
	/*
	 * @OneToMany(mappedBy = "role") private List<UserRole> userRoles;
	 */
	@ManyToMany(mappedBy = "roleList")
	List<User> users;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRoleTitle() {
		return roleTitle;
	}

	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}

	/*
	 * public List<UserRole> getUserRoles() { return userRoles; }
	 * 
	 * public void setUserRoles(List<UserRole> userRoles) { this.userRoles =
	 * userRoles; }
	 */

}