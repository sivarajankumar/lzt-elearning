package org.lztvn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.entity.UserRole;

public class UserRoleImpl implements IUserRoleDAO{
	@PersistenceContext
	EntityManager em;

	@Override
	public UserRole addUserRole(UserRole u) {
		em.persist(u);
		return u;
	}
	
}
