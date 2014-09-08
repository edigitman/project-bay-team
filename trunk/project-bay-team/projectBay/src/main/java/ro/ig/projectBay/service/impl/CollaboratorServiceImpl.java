package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.CollaboratorDAO;
import ro.ig.projectBay.model.Collaborator;
import ro.ig.projectBay.service.CollaboratorService;

@Service(value = "collaboratorService")
@Transactional(readOnly = true)
public class CollaboratorServiceImpl implements CollaboratorService {

	@Autowired
	CollaboratorDAO collaboratorDAO;

	@Override
	public List<Collaborator> getCollaboratorsByCompanyId(Integer id) {
		return collaboratorDAO.getCollaboratorsByCompanyId(id);
	}
	
	@Override
	public Collaborator save(Collaborator collaborator){
		return collaboratorDAO.saveAndFlush(collaborator);
	}
}
