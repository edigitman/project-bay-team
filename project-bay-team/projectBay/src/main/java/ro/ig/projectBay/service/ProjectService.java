package ro.ig.projectBay.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectService {

	public List<Project> findByClient(User client);

	public List<Project> getProjectsByUserCleared(Integer userId);

	public Project getCurrentProject();

	public void setCurrentProject(Project currentProject);

	public void addProject(Project project);

	public List<Project> findPastProjects(Integer id);
}
