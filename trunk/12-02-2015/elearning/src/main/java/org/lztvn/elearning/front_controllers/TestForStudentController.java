package org.lztvn.elearning.front_controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.controllers.AppController;
import org.lztvn.elearning.entities.Content;
import org.lztvn.elearning.entities.Course;
import org.lztvn.elearning.entities.Test1;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.ICourseService;
import org.lztvn.elearning.service.ITestService;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.service.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/listTest")
public class TestForStudentController extends AppController {
	@Autowired
	ICourseService serviceCor;
	@Autowired
	IUserService serviceUser;
	@Autowired
	ITestService serviceTest;

	Utility util;

	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}
	
	@RequestMapping(value = "/alltests")
	public String index(Model model) {
		model.addAttribute("tests", serviceTest.getlistTest());
		return "join_test";
	}

	@RequestMapping(value = "/test")
	public ModelAndView viewTest(Long idTest, Model model) {
		Test1 t = serviceTest.getTestbyID(idTest);
		model.addAttribute("test", t);
		return new ModelAndView("test");
	}
	
	@RequestMapping(value = "/do_test",method = RequestMethod.POST)
	public ModelAndView flogintest(Model model,WebRequest webRequest,HttpSession session, 
			                  final RedirectAttributes redirectAttributes) {
		Long idTest = Long.valueOf(webRequest.getParameter("idTest"));
		
		redirectAttributes.addFlashAttribute("idTest", idTest);
		
		return new ModelAndView("redirect:login");
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model, HttpSession session) {
		//, @ModelAttribute("idCourse") final Long idCourse
		init();
		if (util.checkFrontSession(session) == true) {
			return ("welcome");
		}
		model.addAttribute("user", new User());
		return ("flogin");
	}
	
	// authentication
	@RequestMapping(value = "/authentest", method = RequestMethod.POST)
	public String login(String username, String password, ModelMap model,
			HttpServletRequest request,WebRequest webRequest, RedirectAttributes redirectAttributes) throws IOException {
		if (serviceUser.login(username, password).size() > 0) {
			User u = serviceUser.getUserByUsername(username);
			model.addAttribute("userFLogin", u);
			request.getSession().setAttribute("userFLogin", u);
			String idTest = webRequest.getParameter("idTest");
			if(idTest==null||idTest=="")
		   	  return ("redirect:welcome");
			else{
				Test1 t = serviceTest.getTestbyID(Long.parseLong(idTest, 10));
				model.addAttribute("test", t);
			
				
				return ("test");
			}
		} else {
			model.addAttribute("message", "Sorry, username or password error");
			return ("redirect:login");
		}
	}

}
