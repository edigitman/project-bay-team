package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.ProjectDAO;
import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.ProjectService;

@Service(value = "projectService")
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;

	@Override
	public List<Project> findByClient(User client) {
		return projectDAO.findByClient(client);
	}

	@Override
	public List<Project> getProjectsByUserCleared(User userDA) {
		return projectDAO.getProjectsByUserCleared(userDA);
	}

}
