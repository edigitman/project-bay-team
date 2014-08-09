package ro.ig.projectBay.web;

import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.StreamedContent;
import org.primefaces.model.DefaultStreamedContent;

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
	private StreamedContent file;

	public void init() {
		collaborators = new ArrayList<Collaborator>();
		collaborators = collaboratorService
				.getCollaboratorsByCompanyId(userService.getCurrentUser()
						.getEmployer().getId());
	}

	public boolean renderDownloadLink(Collaborator collaborator) {
		return (collaborator.getCv() == null);
	}

	public StreamedContent fileDownload(Collaborator collaborators) {
		file = null;
		if (collaborators.getCv() != null) {
			InputStream is = new ByteArrayInputStream(collaborators.getCv());
			file = new DefaultStreamedContent(is, "application/pdf",
					collaborators.getLastName() + " "
							+ collaborators.getFirstName() + " - CV");
			return file;
		}
		return null;
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
