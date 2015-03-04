package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.IQuestionDao;
import org.lztvn.elearning.entities.Question;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class QuestionServiceImpl implements IQuestionService{
	IQuestionDao dao;

	public Long addQuest(Question q) {
		return dao.addQuest(q);
	}

	public void editQuest(Question q) {
		dao.editQuest(q);
	}

	public void delQuest(Long idQuest) {
		dao.delQuest(idQuest);
	}

	public Question getQuestion(Long IdQ) {
		return dao.getQuestion(IdQ);
	}

	public IQuestionDao getDao() {
		return dao;
	}

	public void setDao(IQuestionDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Question> getlistQuestionbyTestId(Long id) {
		// TODO Auto-generated method stub
		return dao.getlistQuestionbyTestId(id);
	}
	
	
}
