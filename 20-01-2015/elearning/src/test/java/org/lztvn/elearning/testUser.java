package org.lztvn.elearning;


import org.junit.Before;
import org.junit.Test;
import org.lztvn.entity.Role;
import org.lztvn.entity.User;
import org.lztvn.entity.UserRole;
import org.lztvn.service.IRoleService;
import org.lztvn.service.IUserRoleService;
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
		   	
		   	//IRoleService role = (IRoleService)context.getBean("businessRole");
		   	//role.addRole(new Role("admin", "highest priority"));
		   	
		   	//IUserRoleService userRole = (IUserRoleService)context.getBean("businessUserRole");
		   	//userRole.addUserRole(new UserRole(1, 1));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
	}

}
