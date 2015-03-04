package org.lztvn.elearning.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.lztvn.elearning.entities.Message;

public class MesageImpl implements IMessageDAO{

	@PersistenceContext
	EntityManager em;
	@Override
	public Message addMessage(Message message) {
		em.persist(message);
		return message;
	}

}
