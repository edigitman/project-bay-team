package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import ro.ig.projectBay.model.Collaborator;
import ro.ig.projectBay.service.CollaboratorService;
import ro.ig.projectBay.service.UserService;

@ManagedBean(name = "collaboratorsOverviewBB")
@RequestScoped
public class CollaboratorsOverviewBB {

	@ManagedProperty(value = "#{collaboratorService}")
	CollaboratorService collaboratorService;

	@ManagedProperty(value = "#{userService}")
	private UserService userService;

	public List<Collaborator> collaborators;

	public void init() {
		collaborators = new ArrayList<Collaborator>();
		collaborators = collaboratorService
				.getCollaboratorsByCompanyId(userService.getCurrentUser()
						.getEmployer().getId());
	}

	public CollaboratorService getCollaboratorService() {
		return collaboratorService;
	}

	public void setCollaboratorService(CollaboratorService collaboratorService) {
		this.collaboratorService = collaboratorService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Collaborator> getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(List<Collaborator> collaborators) {
		this.collaborators = collaborators;
	}

}
