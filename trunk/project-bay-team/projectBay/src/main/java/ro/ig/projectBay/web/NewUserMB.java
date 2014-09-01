package ro.ig.projectBay.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ro.ig.projectBay.model.Company;
import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.CompanyService;
import ro.ig.projectBay.service.RoleService;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "newUserMB")
@ViewScoped
public class NewUserMB implements Serializable {

	private static final long serialVersionUID = -6158033929295180159L;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{companyService}")
	private CompanyService companyService;

	@ManagedProperty(value = "#{roleService}")
	private RoleService roleService;

	private List<Company> allCompanies;
	private Integer selectedCompany;
	// TODO:
	// private Company newCompany;

	private User newUser;
	private List<String> userTypeChoiceList;
	private String userTypeChosen;
	private String pass1;
	private String pass2;

	@PostConstruct
	public void init() {
		newUser = new User();
		userTypeChosen = new String();
		pass1 = new String();
		pass2 = new String();
		userTypeChoiceList = userService.getUserTypeChoiceList();
		allCompanies = new ArrayList<>();
		allCompanies = companyService.findAll();
	}

	public String save() {
		List<Role> roleList = new ArrayList<>();
		roleList.add(roleService.findByCode("USER"));
		roleList.add(roleService.findByCode(userTypeChosen));

		newUser.setPassword(pass1);
		newUser.setLogin(newUser.getEmail());
		newUser.setEmployer(companyService.findById(selectedCompany));
		newUser.setRoleList(roleList);
		newUser = userService.saveUser(newUser);
		return "default?faces-redirect=true";
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public List<String> getUserTypeChoiceList() {
		return userTypeChoiceList;
	}

	public void setUserTypeChoiceList(List<String> userTypeChoiceList) {
		this.userTypeChoiceList = userTypeChoiceList;
	}

	public String getUserTypeChosen() {
		return userTypeChosen;
	}

	public void setUserTypeChosen(String userTypeChosen) {
		this.userTypeChosen = userTypeChosen;
	}

	public String getPass1() {
		return pass1;
	}

	public void setPass1(String pass1) {
		this.pass1 = pass1;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public CompanyService getCompanyService() {
		return companyService;
	}

	public void setCompanyService(CompanyService companyService) {
		this.companyService = companyService;
	}

	public List<Company> getAllCompanies() {
		return allCompanies;
	}

	public void setAllCompanies(List<Company> allCompanies) {
		this.allCompanies = allCompanies;
	}

	public Integer getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(Integer selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

}
