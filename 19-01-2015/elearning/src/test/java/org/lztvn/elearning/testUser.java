package org.lztvn.elearning;


import org.junit.Before;
import org.junit.Test;
import org.lztvn.entity.User;
import org.lztvn.service.IUserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testUser {
	ClassPathXmlApplicationContext context ;
	 @Before
	 public void setUp() throws Exception {
	  context = new ClassPathXmlApplicationContext(
	    new String[] { "applicationContext.xml" });
	 }
	
	@Test
	public void test() {
		
		
		try {
			
			
			//context = new ClassPathXmlApplicationContext();
		   	IUserService user = (IUserService)context.getBean("business");
		   	user.addUser(new User("liem", "mod", "mod"));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
