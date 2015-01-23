package org.lztvn.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.lztvn.entity.Message;
import org.springframework.transaction.annotation.Transactional;

public class MesageImpl implements IMessageDAO{

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public Message addMessage(Message message) {
		message.setStatus(false);
		em.persist(message);
		em.flush();
		return message;
	}

}
