package ro.ig.projectBay.service;

import java.util.List;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectService {

	public List<Project> findByClient(User client);

	public List<Project> getProjectsByUserCleared(User userDA);

}
