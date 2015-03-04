package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.entities.Question;

public interface IQuestionService {
	public Long addQuest(Question q);

	public void editQuest(Question q);

	public void delQuest(Long idQuest);
	
	public Question getQuestion(Long IdQ);
	
	public List<Question> getlistQuestionbyTestId(Long id); 

}
