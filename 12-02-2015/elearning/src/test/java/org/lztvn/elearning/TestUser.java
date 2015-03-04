package org.lztvn.elearning;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lztvn.elearning.entities.Contact;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.IContactService;
import org.lztvn.elearning.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
	
	ClassPathXmlApplicationContext context;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
	}

	@Test
	public void test() {
		
		try {
//			IUserService service = (IUserService)context.getBean("metier");
			
			IContactService con = (IContactService)context.getBean("ContactBusiness");
			
			List<Contact> lst1 = con.getListContact();
			System.out.println(" ================>  " + lst1.size());
			con.addContact(new Contact("alian", "alaindelon@yahoo.com", "hello how are yu"));
			
			List<Contact> lst2 = con.getListContact();
			System.out.println("2 ================>  " + lst2.size());
			
//			service.addUser(new User("mdung7ss", "admin123", null, "nguyen", "manhdung", new Date(), "78 high road", "test.jpg", null, true, null, null));
//			service.addUser(new User("jean_alainsss", "testpass", null, "jean phillip", "bourbois", new Date(), "25 rue du commerce", "test2.jpg", null, true, null, null));
//			List<User> lst2 = service.listUser();
//			assertTrue(lst1.size()+ 2 ==lst2.size());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertTrue(e.getMessage(),false);
		}
		
		
	}

}
