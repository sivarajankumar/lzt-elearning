package org.lztvn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.entity.Role;
import org.springframework.transaction.annotation.Transactional;

public class RoleImpl implements IRoleDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public Role addRole(Role role) {
		em.persist(role);
		em.flush();
		return role;
	}
	
}
