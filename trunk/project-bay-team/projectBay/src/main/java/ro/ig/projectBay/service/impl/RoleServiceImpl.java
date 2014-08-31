package ro.ig.projectBay.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.ig.projectBay.dao.RoleDAO;
import ro.ig.projectBay.model.Role;
import ro.ig.projectBay.service.RoleService;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDAO roleDAO;

	public Role findByCode(String code) {
		return roleDAO.findByCode(code);
	}

	public Role save(Role role) {
		return roleDAO.saveAndFlush(role);
	}
}
