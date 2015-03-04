package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Test1;

public class TestDaoImpl implements ITestDao {
	@PersistenceContext
	EntityManager em;

	@Override
	public Long addTest(Test1 u) {
		em.persist(u);
		return u.getId();
	}
	public List<Test1> getlistTest() {
		Query req = em.createQuery("Select t from Test1 t");
		return req.getResultList();
	}
	public List<Test1>  getlistTestbyUserId(Long userid) {
		Query req = em.createQuery("Select t from Test1 t where IdUser = :x");
		req.setParameter("x", userid);
		return req.getResultList();
	}

	public void deleteTest(Long idtset) {

		Test1 c = em.find(Test1.class, idtset);
		em.remove(c);
	}
	public void editTest1(Test1 t){
		  em.merge(t);
	}
	public Test1 getTestbyID(Long id){
		Test1 c = em.find(Test1.class, id);		
		return c;
	}


}
