package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Collaborator;

public interface CollaboratorService {

	List<Collaborator> getCollaboratorsByCompanyId(Integer id);
}
