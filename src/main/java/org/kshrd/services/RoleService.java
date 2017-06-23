package org.kshrd.services;

import java.util.List;

import org.kshrd.model.RoleModel;

public interface RoleService {
	public List<RoleModel> getAllRole();
	public boolean deleteRole(String roleHash);
	public boolean addRole(RoleModel role);
	public RoleModel findRoleByHash(String roleHash);
	public boolean updateRole(RoleModel role);
}
