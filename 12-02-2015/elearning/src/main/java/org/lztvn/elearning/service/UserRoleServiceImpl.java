package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.IUserRoleDAO;
import org.lztvn.elearning.entities.Role;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.entities.UserRole;


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
	@Override
	public List<Role> getRoleByUser(User u) {
		// TODO Auto-generated method stub
		return dao.getRoleByUser(u);
	}

}
