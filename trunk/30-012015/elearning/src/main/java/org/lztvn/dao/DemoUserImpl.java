package org.lztvn.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.lztvn.entity.Message;
import org.lztvn.entity.Role;
import org.lztvn.entity.User;


public class DemoUserImpl implements IUserDAO{
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
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

	@Override
	public List<Role> getRoles(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUser() {
		Query q = em.createQuery("SELECT u FROM User u");
        try{ 
        @SuppressWarnings("unchecked")
		List<User> lstuser = (List<User>)q.getResultList();
        return lstuser;
        }catch(Exception e){ 	          
           return null; 
        } 
	}

	@Override
	public List<User> getAllUserExceptMe(User me) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.id != :id");
		q.setParameter("id", me.getId());
        try{ 
        @SuppressWarnings("unchecked")
		List<User> lstuser = (List<User>)q.getResultList();
        return lstuser;
        }catch(Exception e){ 	          
           return null; 
        } 
	}

	@Override
	public List<Message> getMessageNotifyToMe(User user) {
		user = (User)em.find(User.class, user.getId());
		em.persist(user);
		List<Message> lstMessage = user.getMessageToMe();
		List<Message> result = new ArrayList<Message>();
		for (Message message : lstMessage) {
			if(message.getStatus()==false){
				result.add(message);
			}
		}
		return result;
	}
	
}
