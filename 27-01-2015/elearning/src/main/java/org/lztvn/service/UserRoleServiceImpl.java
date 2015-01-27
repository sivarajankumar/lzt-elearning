package org.lztvn.service;

import org.lztvn.dao.IUserRoleDAO;
import org.lztvn.entity.UserRole;

public class UserRoleServiceImpl implements IUserRoleService{
	IUserRoleDAO dao;
	public void setDao(IUserRoleDAO dao) {
		this.dao = dao;
	}
	@Override
	public UserRole addUserRole(UserRole u) {
		// TODO Auto-generated method stub
		return dao.addUserRole(u);
	}

}
