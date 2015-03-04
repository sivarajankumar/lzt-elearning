package org.lztvn.elearning.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.lztvn.elearning.entities.Category;
import org.lztvn.elearning.service.ICategryService;
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
// @RequestMapping(value = "/adminCat")
@SessionAttributes("editedCat")
public class CategoryController extends AppController {

	@Autowired
	ICategryService service;

	Utility util;

	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	@RequestMapping(value = "/categoris", method = RequestMethod.GET)
	public ModelAndView index(Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			model.addAttribute("category", new Category());
			model.addAttribute("categoris", service.listCat());
			return new ModelAndView("categoris");
		}

	}

	@RequestMapping(value = "/saveCat", method = RequestMethod.POST)
	public String saveCat(@Valid Category c, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("categoris", service.listCat());
			return ("categoris");
		}

		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		if (c.getIdCategory() != null) {
			if (model.asMap().get("editedCat") != null) {
				if (file.isEmpty()) {
					Category us = (Category) model.asMap().get("editedCat");
					// Categorie cat = metier.getCategories(c.getIdcategorie())
					c.setPhoto(us.getPhoto());
				}
			}
			service.modifierCat(c);
		} else
			service.addCategory(c);

		model.addAttribute("category", new Category());
		model.addAttribute("categoris", service.listCat());
		return "categoris";
	}

	@RequestMapping(value = "photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws IOException {
		Category c = service.getCategory(idCat);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value = "/delCat")
	public ModelAndView supp(Long idCat, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			service.deleteCat(idCat);
			model.addAttribute("category", new Category());
			model.addAttribute("categoris", service.listCat());
			return new ModelAndView("categoris");
		}
	}

	@RequestMapping(value = "/editCat")
	public ModelAndView edit(Long idCat, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			Category c = service.getCategory(idCat);
			model.addAttribute("editedCat", c);
			model.addAttribute("category", c);
			model.addAttribute("categoris", service.listCat());
			return new ModelAndView("categoris");
		}
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("category", new Category());
		mv.addObject("category", service.listCat());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categoris");
		return mv;
	}

}
