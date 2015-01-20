package org.lztvn.elearning;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lztvn.entity.User;
import org.lztvn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	IUserService service;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		model.addAttribute("user",new User());
		return "user/login";
	}
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String login(Locale locale, Model model,User user,HttpServletRequest request) {		
		User u = service.login(user.getFirstName(), user.getPassword());
		if(u!=null){
			HttpSession session=request.getSession();  
			session.setAttribute("lzt-user",u);  
			return "redirect:/";
		}else{
			model.addAttribute("user",user);
			return "user/login";
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {		
		 HttpSession session=request.getSession();  
         session.invalidate();  
         return "redirect:/";
	}
}
