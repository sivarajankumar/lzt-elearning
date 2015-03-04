package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Role;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.entities.UserRole;
import org.springframework.transaction.annotation.Transactional;

public class UserRoleImpl implements IUserRoleDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	public UserRole addUserRole(UserRole u) {
		em.persist(u);
		return u;
	}
	
	@Transactional
	@Override
	public List<Role> getRoleByUser(User u) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT role FROM Role role, UserRole urole WHERE role.id=urole.roleId and urole.userId= :id");
        q.setParameter("id", u.getIdUser());
        try{ 
    	@SuppressWarnings("unchecked")
		List<Role> lst = (List<Role>) q.getResultList();
        return lst;
        }catch(Exception e){ 	          
           return null; 
        } 
	}
	 
}
