package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Category;

public class CategoryDaoImpl implements ICategoryDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Long addCategory(Category ca) {
		em.persist(ca);
		return ca.getIdCategory();
	}

	@Override
	public void deleteCat(Long idCat) {
		Category c = em.find(Category.class, idCat);
		em.remove(c);

	}

	@Override
	public void modifierCat(Category c) {
		em.merge(c);
	}

	@Override
	public List<Category> listCat() {
		Query req = em.createQuery("select c from Category c");
		return req.getResultList();

	}

	@Override
	public Category getCategory(Long idCat) {
		// TODO Auto-generated method stub
		return em.find(Category.class, idCat);
	}

	@Override
	public List<Category> listCatInHome() {
		Query req = em.createQuery("select c from Category c where c.inHome = true");
		return req.getResultList();

	}

}
