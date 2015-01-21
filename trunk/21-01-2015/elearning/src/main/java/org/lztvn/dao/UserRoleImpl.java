package org.lztvn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	
}
