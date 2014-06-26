package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Collaborator;

public interface CollaboratorService {

	public List<Collaborator> getCollaboratorsByCompanyId(Integer id);
}
