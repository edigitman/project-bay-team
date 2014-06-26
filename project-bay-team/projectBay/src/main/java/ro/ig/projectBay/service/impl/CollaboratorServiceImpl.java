package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.model.Collaborator;
import ro.ig.projectBay.service.CollaboratorService;

@Service(value = "collaboratorService")
@Transactional(readOnly = true)
public class CollaboratorServiceImpl implements CollaboratorService {

	@Autowired
	CollaboratorService collaboratorService;

	@Override
	public List<Collaborator> getCollaboratorsByCompanyId(Integer id) {
		return collaboratorService.getCollaboratorsByCompanyId(id);
	}
}
