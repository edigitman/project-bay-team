package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectService {

	List<Project> findByClient(User client);

	List<Project> getProjectsByUserCleared(Integer userId);

	Project getCurrentProject();

	void setCurrentProject(Project currentProject);

	void addProject(Project project);

	List<Project> findPastProjects(Integer id);

	List<Project> getWonProjects(Integer id);

	Integer getActiveProjects();

	Integer getClosedProjects();
}
