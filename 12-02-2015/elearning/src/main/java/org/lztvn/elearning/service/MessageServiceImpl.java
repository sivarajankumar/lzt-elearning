package org.lztvn.elearning.service;

import org.lztvn.elearning.dao.IMessageDAO;
import org.lztvn.elearning.entities.Message;


public class MessageServiceImpl implements IMessageService{
	IMessageDAO dao;
	@Override
	public Message addMessage(Message message) {
		// TODO Auto-generated method stub

		return dao.addMessage(message);
	}
	public void setDao(IMessageDAO dao) {
		this.dao = dao;
	}

}
