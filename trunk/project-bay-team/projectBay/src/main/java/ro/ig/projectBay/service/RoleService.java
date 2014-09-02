package ro.ig.projectBay.service;

import ro.ig.projectBay.model.Role;

public interface RoleService {

	Role findByCode(String code);
	
	Role save(Role role);

}
