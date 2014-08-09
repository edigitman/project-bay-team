package ro.ig.projectBay.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.service.ProjectService;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "addProjectBB")
@RequestScoped
public class ProjectAddBB {

	@ManagedProperty(value = "#{projectService}")
	ProjectService projectService;

	@ManagedProperty(value = "#{userService}")
	UserService userService;

	Project newProject;
	private UploadedFile documentation;

	@PostConstruct
	public void init() {
		newProject = new Project();
	}

	public void fileUpload(FileUploadEvent event) {
		try {
			documentation = event.getFile();
			if (documentation != null) {
				newProject.setDocumentation(IOUtils.toByteArray(documentation
						.getInputstream()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addProject() {
		newProject.setClient(userService.getCurrentUser());
		projectService.addProject(newProject);
	}

	public UploadedFile getDocumentation() {
		return documentation;
	}

	public void setDocumentation(UploadedFile documentation) {
		this.documentation = documentation;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	public Project getNewProject() {
		return newProject;
	}

	public void setNewProject(Project newProject) {
		this.newProject = newProject;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
