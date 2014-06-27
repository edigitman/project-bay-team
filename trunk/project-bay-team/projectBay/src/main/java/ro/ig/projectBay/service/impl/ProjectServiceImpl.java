package ro.ig.projectBay.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.ig.projectBay.dao.ProjectDAO;
import ro.ig.projectBay.dao.UserDAO;
import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;
import ro.ig.projectBay.service.ProjectService;

@Service(value = "projectService")
@Transactional(readOnly = true)
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private UserDAO userDAO;
	private Project currentProject;

	@Override
	public List<Project> findByClient(User client) {
		return projectDAO.findByClient(client);
	}

	@Override
	public List<Project> getProjectsByUserCleared(Integer userId) {
		return userDAO.getProjectsByUserCleared(userId);
	}

	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public Project getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Project currentProject) {
		this.currentProject = currentProject;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
