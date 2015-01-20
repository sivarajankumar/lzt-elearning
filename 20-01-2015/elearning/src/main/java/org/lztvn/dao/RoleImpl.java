package org.lztvn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.entity.Role;

public class RoleImpl implements IRoleDAO {
	@PersistenceContext
	EntityManager em;
	public Role addRole(Role role) {
		em.persist(role);
		return role;
	}
	
}
