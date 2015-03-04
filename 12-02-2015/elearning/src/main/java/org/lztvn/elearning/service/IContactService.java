package org.lztvn.elearning.service;

import java.util.List;

import org.lztvn.elearning.entities.Contact;

public interface IContactService {
	public Long addContact(Contact c);
	public void delContact(Long IdCont);
	public List<Contact> getListContact();
	public Contact getContact(Long idContact);
}
