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

@ManagedBean(name = "projectsOverviewDABB")
@RequestScoped
public class ProjectsOverviewDABB {

	@ManagedProperty(value = "#{projectService}")
	ProjectService projectService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public List<Project> projectsCleared;

	@PostConstruct
	public void init() {
		projectsCleared = new ArrayList<Project>();
		projectsCleared = projectService.getProjectsByUserCleared(userService
				.getCurrentUser().getId());
	}

	public void onEdit(RowEditEvent event) {
		// Project proposalToUpdate = (Project) event.getObject();
		// Project.editProposal(proposalToUpdate);
	}

	public void onCancel(RowEditEvent event) {

	}

	public void OnSettingCurrentProject(Project project) {
		projectService.setCurrentProject(project);
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Project> getProjectsCleared() {
		return projectsCleared;
	}

	public void setProjectsCleared(List<Project> projectsCleared) {
		this.projectsCleared = projectsCleared;
	}

}
