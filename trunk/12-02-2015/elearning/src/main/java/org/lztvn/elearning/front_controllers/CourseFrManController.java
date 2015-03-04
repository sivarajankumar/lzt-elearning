package org.lztvn.elearning.front_controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.controllers.AppController;
import org.lztvn.elearning.controllers.CourseController;
import org.lztvn.elearning.entities.Course;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.ICategryService;
import org.lztvn.elearning.service.ICourseService;
import org.lztvn.elearning.service.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("userFLogin")
public class CourseFrManController extends AppController {
	@Autowired
	ICourseService serviceCor;

	@Autowired
	ICategryService serviceCat;
	Utility util;
    //private int page=0;
    private static int nbLigns=3;
    private int nbPages;
   // private int pos= nbLigns*page;
	
	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	
	@RequestMapping(value = "/courses_management", method = RequestMethod.GET)
	public ModelAndView index1(Long page, Model model, HttpSession session) {
		init();
		if (util.checkFrontSession(session) == false) {
			return new ModelAndView("redirect:lstcourses/login");
		} else {
			model.addAttribute("course", new Course());
			model.addAttribute("categories", serviceCat.listCat());
			int pos=0;
			if(page!=null){
            pos = (int) (nbLigns*page);
            model.addAttribute("page", page);
			}
			else{
				model.addAttribute("page", 1);
			}
			User u = (User)session.getAttribute("userFLogin");
			model.addAttribute("courses", serviceCor.listCourseByUserId(u.getIdUser(),pos,nbLigns));
            Long nbCourse = serviceCor.getNbCourseByUserId(u.getIdUser());
            model.addAttribute("nbPage", (nbCourse/nbLigns) + 1);
            
			return new ModelAndView("courses_management");
		}
	}
	
	
	@RequestMapping(value = "/photoCorfront/{idCor}", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCor(@PathVariable Long idCor) throws IOException {
		Course c = serviceCor.getCourse(idCor);
		File f = new File(System.getProperty("java.io.tmpdir") + "/COURSE_" + idCor
				+ "_" + c.getPhotoStr());
		return IOUtils.toByteArray(new FileInputStream(f));
	}
	
	
	@RequestMapping(value = "/saveCorsFront", method = RequestMethod.POST)
	public String saveCour(@Valid Course c,WebRequest webRequest, BindingResult bindingResult,
			Model model, MultipartFile file,HttpSession session) throws IOException, ParseException {
		User u = (User)session.getAttribute("userFLogin");
//		Long page = Long.valueOf(webRequest.getParameter("page"));
		Long page = 0l;
		int pos=0;
		pos = (int) (nbLigns*page);
        model.addAttribute("page", page);
		
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("courses", serviceCor.listCourseByUserId(u.getIdUser(),pos,nbLigns));
			model.addAttribute("course", new Course());
			model.addAttribute("categories", serviceCat.listCat());
			Long nbCourse = serviceCor.getNbCourseByUserId(u.getIdUser());
            model.addAttribute("nbPage", (nbCourse/nbLigns) + 1);
			return ("courses_management");
		}

		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			c.setPhotoStr(file.getOriginalFilename());
			Long idC = null;
			if (c.getIdCourse() == null) {
				c.setDateCreation(new Date());
				idC = serviceCor.addCourse(c);
			} else {
				c.setDateStart(new Date());
				serviceCor.modifierCourse(c);
				idC = c.getIdCourse();
			}

			file.transferTo(new File(path + "/" + "COURSE_" + idC + "_"
					+ file.getOriginalFilename()));
		} else {
			if (c.getIdCourse() == null) {
				c.setDateCreation(new Date());
				serviceCor.addCourse(c);
			}
			else{
				c.setPhotoStr(serviceCor.getCourse(c.getIdCourse()).getPhotoStr());
				c.setDateCreation(serviceCor.getCourse(c.getIdCourse()).getDateCreation());
				serviceCor.modifierCourse(c);
			}
		}
		
		
		
		
		model.addAttribute("course", new Course());
		model.addAttribute("courses", serviceCor.listCourseByUserId(u.getIdUser(),pos,nbLigns));
		Long nbCourse = serviceCor.getNbCourseByUserId(u.getIdUser());
        model.addAttribute("nbPage", (nbCourse/nbLigns) + 1);
		model.addAttribute("categories", serviceCat.listCat());
//		model.addAttribute("teacher", serviceUser.listTeacher());
		return "courses_management";
	}
	
	@RequestMapping(value = "/delCorsFront")
	public ModelAndView supp(Long idCor,Long page, Model model, HttpSession session) {
		init();
		if (util.checkFrontSession(session) == false) {
			return new ModelAndView("redirect:lstcourses/login");
		} else {
			serviceCor.deleteCourse(idCor);
			User u = (User)session.getAttribute("userFLogin");
			model.addAttribute("course", new Course());
		    model.addAttribute("categories", serviceCat.listCat());
			int pos=0;
			if(page!=null){
            pos = (int) (nbLigns*page);
            model.addAttribute("page", page);
			}
			else{
				model.addAttribute("page", 1);
			}
			model.addAttribute("courses", serviceCor.listCourseByUserId(u.getIdUser(),pos,nbLigns));
			Long nbCourse = serviceCor.getNbCourseByUserId(u.getIdUser());
            model.addAttribute("nbPage", (nbCourse/nbLigns) + 1);
			
			return new ModelAndView("courses_management");
		}
	}

	@RequestMapping(value = "/editCorsFront")
	public ModelAndView edit(Long idCor,Long page, Model model, HttpSession session) {
		init();
		if (util.checkFrontSession(session) == false) {
			return new ModelAndView("redirect:lstcourses/login");
		} else {
			Course c = serviceCor.getCourse(idCor);
			User u = (User)session.getAttribute("userFLogin");
			model.addAttribute("editedCor", c);
			model.addAttribute("course", c);
		
			model.addAttribute("categories", serviceCat.listCat());
			
			int pos=0;
			if(page!=null){
            pos = (int) (nbLigns*page);
            model.addAttribute("page", page);
			}
			else{
				model.addAttribute("page", 1);
			}
			
			model.addAttribute("courses", serviceCor.listCourseByUserId(u.getIdUser(),pos,nbLigns));
			Long nbCourse = serviceCor.getNbCourseByUserId(u.getIdUser());
            model.addAttribute("nbPage", (nbCourse/nbLigns) + 1);
			
			return new ModelAndView("courses_management");
		}
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("course", new Course());
		mv.addObject("courses", serviceCor.listCourse());
		mv.addObject("categories", serviceCat.listCat());
		
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("courses");
		return mv;
	}
}
