package org.lztvn.elearning.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.elearning.entities.Role;

public class RoleImpl implements IRoleDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	public Role addRole(Role role) {
		em.persist(role);
		return role;
	}

}
