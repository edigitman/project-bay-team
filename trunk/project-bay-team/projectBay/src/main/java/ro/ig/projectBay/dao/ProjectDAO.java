package ro.ig.projectBay.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.ig.projectBay.model.Project;
import ro.ig.projectBay.model.User;

public interface ProjectDAO extends JpaRepository<Project, String> {

	public List<Project> findByClient(User client);

}
