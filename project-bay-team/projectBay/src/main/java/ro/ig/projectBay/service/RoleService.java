package ro.ig.projectBay.service;

import ro.ig.projectBay.model.Role;

public interface RoleService {

	public Role findByCode(String code);
	
	public Role save(Role role);

}
