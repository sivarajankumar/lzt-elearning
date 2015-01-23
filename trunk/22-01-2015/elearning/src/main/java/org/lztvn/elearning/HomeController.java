package org.lztvn.elearning;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.lztvn.entity.Role;
import org.lztvn.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("lzt-user")
public class HomeController extends AppController{
	public HomeController() {
		this.roles = new ArrayList<Role>();
		this.roles.add(new Role("admin","some descriptions"));	
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		//logger.info("Welcome home! The client locale is {}.", model.asMap().get("lzt-user").toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
        if(model.asMap().get("lzt-user")!=null){  
        User user=(User)model.asMap().get("lzt-user");   
        model.addAttribute("name", user.getFirstName());
        }  
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
