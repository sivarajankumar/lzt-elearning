package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Course;

public class CourseDaoImpl implements ICourseDao{
	@PersistenceContext
	private EntityManager em;
	@Override
	public Long addCourse(Course c) {
		em.persist(c);
		return c.getIdCourse();
	}

	@Override
	public void deleteCourse(Long idCors) {
		Course c = em.find(Course.class, idCors);
		em.remove(c);
		
	}

	@Override
	public void modifierCourse(Course c) {
		em.merge(c);
		
	}

	@Override
	public List<Course> listCourse() {
		Query req = em.createQuery("select c from Course c");
		return req.getResultList();
	}

	@Override
	public Course getCourse(Long idCors) {
		return em.find(Course.class, idCors);
	}

	@Override
	public List<Course> listCourseInHome() {
		Query req = em.createQuery("select c from Course c where c.inHome = true");
		return req.getResultList();
	
	}

	@Override
	public List<Course> listCourseByUserId(Long idUser, int position, int nb_course) {
		Query req = em.createQuery("select c from Course c where idUser = :x order by c.dateStart desc");
		req.setParameter("x",idUser);
		req.setFirstResult(position);
		req.setMaxResults(nb_course);
		return req.getResultList();
	}

	@Override
	public Long getNbCourseByUserId(Long idUser) {
		Query req = em.createQuery("select count(c) from Course c where idUser = :x");
		req.setParameter("x",idUser);
		return (Long) req.getResultList().get(0);
	}

}
