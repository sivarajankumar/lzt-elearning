package org.lztvn.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.entity.Role;
import org.lztvn.entity.User;
import org.lztvn.entity.UserRole;
import org.springframework.transaction.annotation.Transactional;

public class UserRoleImpl implements IUserRoleDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public UserRole addUserRole(UserRole u) {
		em.persist(u);
		em.flush();
		return u;
	}
	
	@Transactional
	@Override
	public List<Role> getRoleByUser(User u) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT role FROM Role role, UserRole urole WHERE role.id=urole.roleId and urole.userId= :id");
        q.setParameter("id", u.getId());
        try{ 
    	@SuppressWarnings("unchecked")
		List<Role> lst = (List<Role>) q.getResultList();
        return lst;
        }catch(Exception e){ 	          
           return null; 
        } 
	}
	 
}
