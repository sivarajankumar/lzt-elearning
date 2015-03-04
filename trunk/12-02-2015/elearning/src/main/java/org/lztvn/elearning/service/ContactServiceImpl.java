package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.dao.IContactDao;
import org.lztvn.elearning.entities.Contact;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public class ContactServiceImpl implements IContactService{
    
	private IContactDao dao;
	@Override
	public Long addContact(Contact c) {
		// TODO Auto-generated method stub
		return dao.addContact(c);
	}

	@Override
	public void delContact(Long IdCont) {
		dao.delContact(IdCont);
	}

	@Override
	public List<Contact> getListContact() {
		return dao.getListContact();
	}

	@Override
	public Contact getContact(Long idContact) {
		return dao.getContact(idContact);
	}

	public IContactDao getDao() {
		return dao;
	}

	public void setDao(IContactDao dao) {
		this.dao = dao;
	}
	
	

}
