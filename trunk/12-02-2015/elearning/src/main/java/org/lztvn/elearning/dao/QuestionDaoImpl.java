package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Question;
import org.lztvn.elearning.entities.Test1;

public class QuestionDaoImpl implements IQuestionDao{
	@PersistenceContext
	EntityManager em;
	@Override
	public Long addQuest(Question q){
		em.persist(q);
	return q.getQestId();
	}
	@Override
	public void editQuest(Question q){
		em.merge(q);
	}
	@Override
	public void delQuest(Long idQuest){
		Question q = em.find(Question.class, idQuest);
		em.remove(q);
	}
	@Override
	public Question getQuestion(Long IdQ){
		Question q = em.find(Question.class, IdQ);
		return  q;
	}
	public List<Question> getlistQuestionbyTestId(Long id){
		Query req = em.createQuery("select q from Question q where test.id = :x" );
		req.setParameter("x", id);
		return req.getResultList();
	}
}