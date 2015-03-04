package org.lztvn.elearning.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.lztvn.elearning.entities.Contact;

public class ContactDaoImpl implements IContactDao{
	@PersistenceContext
    EntityManager em;
	@Override
	public Long addContact(Contact c) {
		em.persist(c);
		return c.getIdmessage();
	}

	@Override
	public void delContact(Long IdCont) {
		Contact c= em.find(Contact.class, IdCont);
		em.remove(c);
		
	}

	@Override
	public List<Contact> getListContact() {
		Query req = em.createQuery("select c from Contact c");
		return req.getResultList();
	}

	@Override
	public Contact getContact(Long idContact) {
        Contact c = em.find(Contact.class, idContact);
		return c;
	}

}
