package org.lztvn.service;


import java.util.List;

import org.lztvn.dao.IUserDAO;
import org.lztvn.entity.User;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class UserServiceImpl implements IUserService{
    IUserDAO dao;
	//@Override
	//public Long addUser(User u) {
		// TODO Auto-generated method stub
		//return dao.addUser(u);
	//}
    @Override
    public Long addUser(User u){
    	return dao.addUser(u);
    }
	public void setDao(IUserDAO dao) {
		this.dao = dao;
	}
	@Override
	public List<User> findByLastName(String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User login(String name, String pass) {
		// TODO Auto-generated method stub
		return dao.login(name, pass);
	}
	
}
