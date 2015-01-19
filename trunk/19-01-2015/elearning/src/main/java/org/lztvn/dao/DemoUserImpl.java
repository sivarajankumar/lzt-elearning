package org.lztvn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.entity.User;

public class DemoUserImpl implements IUserDAO{
	@PersistenceContext
	EntityManager em;
	@Override
	public List<User> findByLastName(String lastName) {
		return null;
		
	}

	@Override
	public void login(String name, String pass) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Long addUser(User u) {
		em.persist(u);
		return u.getId() ;
	}
	
}
