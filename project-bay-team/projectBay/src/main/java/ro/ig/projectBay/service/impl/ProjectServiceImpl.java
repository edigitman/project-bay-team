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
		return projectDAO.getProjectsByUserCleared(userId);
	}

	@Override
	public void addProject(Project project) {
		projectDAO.saveAndFlush(project);
	}

	@Override
	public List<Project> findPastProjects(Integer id) {
		return projectDAO.findPastProjects(id);
	}

	@Override
	public List<Project> getWonProjects(Integer id) {
		return projectDAO.getWonProjects(id);
	}

	public Integer getActiveProjects() {
		int active = 1;
		return projectDAO.getNumberOfProjectsByValidity(active);
	}

	public Integer getClosedProjects() {
		int inactive = 0;
		return projectDAO.getNumberOfProjectsByValidity(inactive);
	}

	// --------------------- GETTERS AND SETTERS ---------------------

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
