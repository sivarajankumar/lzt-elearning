package org.lztvn.service;

import org.lztvn.entity.Role;

public class RoleServiceImpl implements IRoleService {
	IRoleService dao;
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return dao.addRole(role);
	}
	public void setDao(IRoleService dao) {
		this.dao = dao;
	}
	
}
