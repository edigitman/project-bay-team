package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.service.ProjectService;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "pastProjectsBB")
@RequestScoped
public class PastProjectsBB {
	@ManagedProperty(value = "#{projectService}")
	private ProjectService projectService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public List<Project> projectsList;

	@PostConstruct
	public void init() {
		projectsList = new ArrayList<Project>();
		projectsList = projectService.findPastProjects(userService
				.getCurrentUser().getId());
	}

	public String toProjectDetails(Project currentProject) {
		projectService.setCurrentProject(currentProject);
		return "projectDetails?faces-redirect=true";
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public List<Project> getProjectsList() {
		return projectsList;
	}

	public void setProjectsList(List<Project> projectsList) {
		this.projectsList = projectsList;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
