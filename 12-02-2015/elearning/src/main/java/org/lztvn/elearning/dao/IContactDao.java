package org.lztvn.elearning.dao;

import java.util.List;

import org.lztvn.elearning.entities.Contact;

public interface IContactDao {
	public Long addContact(Contact c);
	public void delContact(Long IdCont);
	public List<Contact> getListContact();
	public Contact getContact(Long idContact);
}
