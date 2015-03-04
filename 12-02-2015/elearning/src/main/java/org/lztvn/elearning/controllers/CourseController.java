package org.lztvn.elearning.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.entities.Course;
import org.lztvn.elearning.service.ICategryService;
import org.lztvn.elearning.service.ICourseService;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.service.Utility;
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
@SessionAttributes("editedCor")
public class CourseController extends AppController {
	@Autowired
	ICourseService serviceCor;

	@Autowired
	ICategryService serviceCat;
	@Autowired
	IUserService serviceUser;
	Utility util;

	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public ModelAndView index(Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			model.addAttribute("course", new Course());
			model.addAttribute("courses", serviceCor.listCourse());
			model.addAttribute("categories", serviceCat.listCat());
			model.addAttribute("teachers", serviceUser.listTeacher());
			return new ModelAndView("courses");
		}

	}

	@RequestMapping(value = "/saveCor", method = RequestMethod.POST)
	public String saveCat(@Valid Course c, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException, ParseException {
		
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("courses", serviceCor.listCourse());
			model.addAttribute("categories", serviceCat.listCat());
			model.addAttribute("teachers", serviceUser.listTeacher());
			return ("courses");
		}

		if (!file.isEmpty()) {
			String path = System.getProperty("java.io.tmpdir");
			c.setPhotoStr(file.getOriginalFilename());
			Long idC = null;
			if (c.getIdCourse() == null) {
				c.setDateCreation(new Date());
				idC = serviceCor.addCourse(c);
			} else {
				c.setDateCreation(serviceCor.getCourse(c.getIdCourse()).getDateCreation());
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
				c.setDateStart(new Date());
				serviceCor.modifierCourse(c);
			}
		}
		
		model.addAttribute("course", new Course());
		model.addAttribute("courses", serviceCor.listCourse());
		model.addAttribute("categories", serviceCat.listCat());
		model.addAttribute("teachers", serviceUser.listTeacher());
		return "courses";
	}

	@RequestMapping(value = "photoCor", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCor(Long idCor) throws IOException {
		Course c = serviceCor.getCourse(idCor);
		File f = new File(System.getProperty("java.io.tmpdir") + "/COURSE_" + idCor
				+ "_" + c.getPhotoStr());
		return IOUtils.toByteArray(new FileInputStream(f));
	}

	@RequestMapping(value = "/delCors")
	public ModelAndView supp(Long idCor, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			serviceCor.deleteCourse(idCor);
			model.addAttribute("course", new Course());
			model.addAttribute("courses", serviceCor.listCourse());
			model.addAttribute("categories", serviceCat.listCat());
			model.addAttribute("teachers", serviceUser.listTeacher());
			return new ModelAndView("courses");
		}
	}

	@RequestMapping(value = "/editCors")
	public ModelAndView edit(Long idCor, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			Course c = serviceCor.getCourse(idCor);
			
			model.addAttribute("editedCor", c);
			model.addAttribute("course", c);
			model.addAttribute("courses", serviceCor.listCourse());
			model.addAttribute("categories", serviceCat.listCat());
			model.addAttribute("teachers", serviceUser.listTeacher());
			return new ModelAndView("courses");
		}
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("course", new Course());
		mv.addObject("courses", serviceCor.listCourse());
		mv.addObject("categories", serviceCat.listCat());
		mv.addObject("teacher", serviceUser.listTeacher());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("courses");
		return mv;
	}

}
