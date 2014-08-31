package ro.ig.projectBay.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.ig.projectBay.model.Role;

public interface RoleDAO extends JpaRepository<Role, String> {

	public Role findByCode(String code);
}
