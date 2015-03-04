package org.lztvn.elearning.controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.service.Utility;
import org.lztvn.elearning.unityclass.FriendStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
// @RequestMapping(value = "/register")
@SessionAttributes({"editedUser","userFLogin"})
public class UserController extends AppController{

	@Autowired
	IUserService service;

	Utility util;

	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView index(Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			model.addAttribute("user", new User());
			model.addAttribute("users", service.listUser());
			return new ModelAndView("users");
		}
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@Valid User u, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("users", service.listUser());
			return ("users");
		}

		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			u.setPhoto(file.getOriginalFilename());
			Long idU = null;
			if (u.getIdUser() == null) {
				idU = service.addUser(u);
			} else {
               service.modifierUser(u);
			   idU = u.getIdUser();
			}

			file.transferTo(new File(path + "/" + "USER_" + idU + "_"
					+ file.getOriginalFilename()));
		} else {
			if (u.getIdUser() == null) {
				service.addUser(u);
			}
			else{
				u.setPhoto(service.getUser(u.getIdUser()).getPhoto());
				service.modifierUser(u);
			}
		}

		model.addAttribute("user", new User());
		model.addAttribute("users", service.listUser());
		return "users";
	}

//	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
//	@ResponseBody
//	public byte[] photoUser(Long idUser) throws IOException {
//		User u = service.getUser(idUser);
//		return IOUtils.toByteArray(new ByteArrayInputStream(u.getPhoto()));
//	}
	
	@RequestMapping(value = "photoUser", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoUser(Long idUser) throws IOException {
		User u = service.getUser(idUser);
		File f = new File(System.getProperty("java.io.tmpdir") + "/USER_" + idUser
				+ "_" + u.getPhoto());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	

	@RequestMapping(value = "/suppUser")
	public ModelAndView supp(Long idUser, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			service.deleteUser(idUser);
			model.addAttribute("user", new User());
			model.addAttribute("users", service.listUser());
			return new ModelAndView("users");
		}
    }

	@RequestMapping(value = "/viewUser")
	public String view(Long id, Model model,HttpSession session) {
		User me = (User)session.getAttribute("userFLogin");
		User u = service.getUser(id);
		
		
		if(me!=null){
			if(me.getIdUser().longValue()==u.getIdUser().longValue()){
				model.addAttribute("user", u);
				model.addAttribute("pageTitle", u.getFirstName()+" "+u.getLastName());
				return "profile.me";
			}else{
			model.addAttribute("relation",service.relation(me,u));
			model.addAttribute("user", u);
			model.addAttribute("pageTitle", u.getFirstName()+" "+u.getLastName());
			
			return "profile.pub";
			}
		}else{
			model.addAttribute("relation",FriendStatus.NOT_ADD);
			model.addAttribute("user", u);
			model.addAttribute("pageTitle", u.getFirstName()+" "+u.getLastName());
			
			return "profile.pri";
		}
		
		
	}
	@RequestMapping(value = "/editUser")
	public ModelAndView edit(Long idUser, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			User u = service.getUser(idUser);
			model.addAttribute("editeduser", u);
			model.addAttribute("user", u);
			model.addAttribute("users", service.listUser());
				
			return new ModelAndView("users");
		}

	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new User());
		mv.addObject("user", service.listUser());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("Users");
		return mv;
	}

}
