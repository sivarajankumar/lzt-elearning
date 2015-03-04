package org.lztvn.elearning.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.service.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userLogin")
public class LoginController extends AppController{
	@Autowired
	IUserService service;
	
	Utility util;
	private void init(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		this.util = (Utility) context.getBean("util");
    }
	
	@RequestMapping("/login")  
	public ModelAndView index(Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == true) {
			return new ModelAndView("redirect:users");
		}
		model.addAttribute("user", new User());
		return new ModelAndView("login");
	}
	
   //authentication	
	@RequestMapping(value = "/authen", method = RequestMethod.POST)
	public String login(String username, String password,
			ModelMap model, HttpSession session) throws IOException {
		 if (service.login(username,password).size() > 0) {
			 User u = service.getUserByUsername(username);
			 model.addAttribute("userLogin", u);
			 session.setAttribute("userLogin", u);
			// model.addAttribute("message", "username or password is incorrect");
			return ("redirect:/users");
		}else{//new ModelAndView
		  model.addAttribute( "message","Sorry, username or password error");
          return ("redirect:login");
          }
	}
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
	    mv.addObject("exception", ex.getMessage());
		mv.setViewName("user");
		return mv;
	}
}
