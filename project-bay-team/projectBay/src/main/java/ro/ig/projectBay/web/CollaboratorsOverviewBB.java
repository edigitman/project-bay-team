package ro.ig.projectBay.web;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

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

	private Collaborator selectedToDeleteCollaborator;
	public List<Collaborator> collaborators;
	private StreamedContent file;
	private byte[] cv;

	public void init() {
		collaborators = new ArrayList<Collaborator>();
		selectedToDeleteCollaborator = new Collaborator();
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

	public void fileUpload(FileUploadEvent event) {
		cv = event.getFile().getContents();
	}

	public void onEdit(RowEditEvent event) {
		Collaborator collaborateursToUpdate = (Collaborator) event.getObject();
		collaboratorService.save(collaborateursToUpdate);
	}

	public void onCancel(RowEditEvent event) {
		event.getObject();
	}

	// ---------------------------------------------------------
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

	public Collaborator getSelectedToDeleteCollaborator() {
		return selectedToDeleteCollaborator;
	}

	public void setSelectedToDeleteCollaborator(
			Collaborator selectedToDeleteCollaborator) {
		this.selectedToDeleteCollaborator = selectedToDeleteCollaborator;
	}

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public byte[] getCv() {
		return cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}

}
