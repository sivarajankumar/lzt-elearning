package org.lztvn.elearning.front_controllers;


import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.controllers.CourseController;
import org.lztvn.elearning.entities.Category;
import org.lztvn.elearning.entities.Contact;
import org.lztvn.elearning.entities.Content;
import org.lztvn.elearning.entities.Course;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.ICategryService;
import org.lztvn.elearning.service.IContactService;
import org.lztvn.elearning.service.IContentService;
import org.lztvn.elearning.service.ICourseService;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.service.Utility;
import org.lztvn.elearning.validation.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
@RequestMapping(value = "/lstcourses")
@SessionAttributes("userFLogin")
public class CourseFrontController extends CourseController {
	@Autowired
	ICourseService serviceCor;
	@Autowired
	ICategryService serviceCat;
	@Autowired
	IUserService serviceUser;
	@Autowired
	IContentService serviceContent;
	
	Utility util;

	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		// model.addAttribute("courses", serviceCor.listCourse());
		model.addAttribute("courses", serviceCor.listCourseInHome());
		model.addAttribute("categoris", serviceCat.listCatInHome());
		model.addAttribute("users", serviceUser.listTeacher());
		// List<Content> contents = serviceContent.listConType("banner");
		// List<String> urlPhotoList = null ;
		// for(Content c:contents){
		// String urlPhoto = "photoCon?idCon="+c.getIdContent();
		// urlPhotoList.add(urlPhoto);
		// }
		model.addAttribute("contents", serviceContent.listConType("banner"));

		Content con = (Content) serviceContent.listConType("middle_content")
				.get(0);
		model.addAttribute("content_middle", con);
		return new ModelAndView("lstcourses");
	}

	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoUser(Long idUser) throws IOException {
		User u = serviceUser.getUser(idUser);
		File f = new File(System.getProperty("java.io.tmpdir") + "/USER_" + idUser
				+ "_" + u.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	
	@RequestMapping(value = "photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException {
		Category c = serviceCat.getCategory(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}
//	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
//	@ResponseBody
//	public byte[] photoUser(Long idUser) throws IOException {
//		User u = serviceUser.getUser(idUser);
//		return IOUtils.toByteArray(new ByteArrayInputStream(u.getPhoto()));
//	}

	@RequestMapping(value = "photoCon", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCon(Long idCon) throws IOException {
		Content c = serviceContent.getContent(idCon);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value = "/course")
	public ModelAndView viewCourse(Long idCor, Model model) {
		Course c = serviceCor.getCourse(idCor);
		model.addAttribute("course", c);
		return new ModelAndView("course");
	}

	@RequestMapping(value = "/watch_video",method = RequestMethod.POST)
	public ModelAndView flogin(Model model,WebRequest webRequest,HttpSession session, 
			                  final RedirectAttributes redirectAttributes) {
		Long idCourse = Long.valueOf(webRequest.getParameter("idCourse"));
		
		redirectAttributes.addFlashAttribute("idCourse", idCourse);
		
		return new ModelAndView("redirect:login");
	}



	@RequestMapping(value = "/welcome")
	public ModelAndView welcome(Model model, HttpSession session) {
		init();
		if (!util.checkFrontSession(session) == true) {
			return new ModelAndView("redirect:login");
		}
		model.addAttribute("user", new User());
		return new ModelAndView("welcome");
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
	@RequestMapping(value = "/authen", method = RequestMethod.POST)
	public String login(String username, String password, ModelMap model,
			HttpServletRequest request,WebRequest webRequest, RedirectAttributes redirectAttributes) throws IOException {
		if (serviceUser.login(username, password).size() > 0) {
			User u = serviceUser.getUserByUsername(username);
			model.addAttribute("userFLogin", u);
			request.getSession().setAttribute("userFLogin", u);
			String idCourse = webRequest.getParameter("idCourse");
			if(idCourse==null||idCourse=="")
		   	  return ("redirect:welcome");
			else{
				Course c = serviceCor.getCourse( Long.parseLong(idCourse, 10));
				model.addAttribute("course", c);
				model.addAttribute("idCourse_video", Long.parseLong(idCourse, 10));
				redirectAttributes.addAttribute("idCourse_video", Long.parseLong(idCourse, 10));
				return ("course");
			}
		} else {
			model.addAttribute("message", "Sorry, username or password error");
			return ("redirect:login");
		}
	}

	
	@RequestMapping(value = "/register")
	public ModelAndView register(Model model,HttpServletRequest request, HttpServletResponse response) {
//		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//		localeResolver.setLocale(request, response, StringUtils.parseLocaleString("jp"));
		model.addAttribute("user", new User());
		return new ModelAndView("register");
	}
	
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
    public ModelAndView about(Model model){
		Content about = (Content) serviceContent.listConType("about")
				.get(0);
		Content text_about_right = (Content) serviceContent.listConType("text_about_right")
				.get(0);
		Content text_about_bottom = (Content) serviceContent.listConType("text_about_bottom")
				.get(0);
		model.addAttribute("about", about);
		model.addAttribute("text_about_right", text_about_right);
		model.addAttribute("text_about_bottom", text_about_bottom);
		model.addAttribute("courses", serviceCor.listCourseInHome());
    	return new ModelAndView("about");
    }
	

	
	
	@RequestMapping(value = "/allcourses")
	public ModelAndView allcourses(Model model, HttpSession session) {
		model.addAttribute("courses", serviceCor.listCourseInHome());
		return new ModelAndView("allcourses");
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@Valid User u, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException {
		 UserValidation userValidator = new UserValidation(serviceUser);
	     userValidator.validate(u, bindingResult);
		if (bindingResult.hasErrors()) {
			return ("register");
		}

		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			u.setPhoto(file.getOriginalFilename());
			Long idU = null;
			idU = serviceUser.addUser(u);
			file.transferTo(new File(path + "/" + "USER_" + idU + "_"
					+ file.getOriginalFilename()));
		} else {
				serviceUser.addUser(u);
		}
		
        model.addAttribute("successRegister", "Registration successfull, you will receive the link to validate your email, Thank you !");
	
		return "register_succes";
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
