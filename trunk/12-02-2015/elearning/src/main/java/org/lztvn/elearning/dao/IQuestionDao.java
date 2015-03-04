package org.lztvn.elearning.dao;

import java.util.List;

import org.lztvn.elearning.entities.Question;
import org.lztvn.elearning.entities.User;

public interface IQuestionDao {
	public Long addQuest(Question q);

	public void editQuest(Question q);

	public void delQuest(Long idQuest);

	public Question getQuestion(Long IdQ);

	public List<Question> getlistQuestionbyTestId(Long id);
}
