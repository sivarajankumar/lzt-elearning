package org.lztvn.service;


import org.lztvn.dao.IMessageDAO;
import org.lztvn.entity.Message;

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
