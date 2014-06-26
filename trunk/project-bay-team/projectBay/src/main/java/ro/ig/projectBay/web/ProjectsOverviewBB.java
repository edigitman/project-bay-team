package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.RowEditEvent;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.service.ProjectService;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "projectsOverviewBB")
@RequestScoped
public class ProjectsOverviewBB {

	@ManagedProperty(value = "#{projectService}")
	ProjectService projectService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public List<Project> projectsProposed;

	@PostConstruct
	public void init() {
		projectsProposed = new ArrayList<Project>();
		projectsProposed = projectService.findByClient(userService
				.getCurrentUser());
	}

	public void onEdit(RowEditEvent event) {
		// Project proposalToUpdate = (Project) event.getObject();
		// Project.editProposal(proposalToUpdate);
	}

	public void onCancel(RowEditEvent event) {

	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public List<Project> getProjectsProposed() {
		return projectsProposed;
	}

	public void setProjectsProposed(List<Project> projectsProposed) {
		this.projectsProposed = projectsProposed;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
