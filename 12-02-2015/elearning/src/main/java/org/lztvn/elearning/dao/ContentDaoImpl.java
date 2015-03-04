package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Content;
import org.lztvn.elearning.entities.Course;

public class ContentDaoImpl implements IContentDao{
	@PersistenceContext
	private EntityManager em;
	@Override
	public Long addContent(Content c) {
		// TODO Auto-generated method stub
		 em.persist(c);
		 return c.getIdContent();
	}

	@Override
	public void deleteCon(Long idCon) {
		Content c = em.find(Content.class, idCon);
		em.remove(c);
		
	}

	@Override
	public void modifierCon(Content c) {
		em.merge(c);
		
	}

	@Override
	public Content getContent(Long idCon) {
		return em.find(Content.class, idCon);
	}

	@Override
	public List<Content> listCon() {
		Query req = em.createQuery("select c from Content c");
	return req.getResultList();
	}
	
	@Override
	public List<Content> listConType(String typeContent) {
		Query req = em.createQuery("select c from Content c where typeContent=:x and active = true");
		req.setParameter("x",typeContent);
		return req.getResultList();
	}

}
