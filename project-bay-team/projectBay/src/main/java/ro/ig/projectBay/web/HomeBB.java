package ro.ig.projectBay.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.service.ProjectService;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "homeBB")
@ViewScoped
public class HomeBB {

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	@ManagedProperty(value = "#{projectService}")
	ProjectService projectService;

	private Integer numberOfDAs;
	private Integer numberOfClients;
	private Integer numberOfActiveProjects;
	private Integer numberOfClosedProjects;

	@PostConstruct
	public void init() {
		numberOfClients = null;
		numberOfDAs = null;
		numberOfActiveProjects = null;
		numberOfClosedProjects = null;
		//
		numberOfClients = userService.getNumberOfClients().size();
		numberOfDAs = userService.getNumberOfDAs().size();
		numberOfActiveProjects = projectService.getActiveProjects();
		numberOfClosedProjects = projectService.getClosedProjects();
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public Integer getNumberOfDAs() {
		return numberOfDAs;
	}

	public void setNumberOfDAs(Integer numberOfDAs) {
		this.numberOfDAs = numberOfDAs;
	}

	public Integer getNumberOfClients() {
		return numberOfClients;
	}

	public void setNumberOfClients(Integer numberOfClients) {
		this.numberOfClients = numberOfClients;
	}

	public Integer getNumberOfActiveProjects() {
		return numberOfActiveProjects;
	}

	public void setNumberOfActiveProjects(Integer numberOfActiveProjects) {
		this.numberOfActiveProjects = numberOfActiveProjects;
	}

	public Integer getNumberOfClosedProjects() {
		return numberOfClosedProjects;
	}

	public void setNumberOfClosedProjects(Integer numberOfClosedProjects) {
		this.numberOfClosedProjects = numberOfClosedProjects;
	}

}
