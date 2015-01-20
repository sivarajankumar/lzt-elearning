package org.lztvn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.entity.User;

public class DemoUserImpl implements IUserDAO{
	@PersistenceContext
	EntityManager em;
	@Override
	public List<User> findByLastName(String lastName) {
		return null;
	}

	@Override
	public User login(String name, String pass) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT u FROM User u WHERE u.firstName = :name and u.password= :pass");
        q.setParameter("name", name);
        q.setParameter("pass", pass);
        try{ 
        User user = (User) q.getSingleResult();
        return user;
        }catch(Exception e){ 	          
           return null; 
        } 
	}

	@Override
	public Long addUser(User u) {
		em.persist(u);
		return u.getId() ;
	}
	
}
