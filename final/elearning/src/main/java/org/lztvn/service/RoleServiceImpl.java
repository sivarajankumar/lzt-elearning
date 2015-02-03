package org.lztvn.service;

import org.lztvn.dao.IRoleDAO;
import org.lztvn.entity.Role;

public class RoleServiceImpl implements IRoleService {
	IRoleDAO dao;
	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return dao.addRole(role);
	}
	public void setDao(IRoleDAO dao) {
		this.dao = dao;
	}
	
}
