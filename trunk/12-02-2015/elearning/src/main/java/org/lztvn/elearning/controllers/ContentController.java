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
import org.lztvn.elearning.entities.Content;
import org.lztvn.elearning.service.IContentService;
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
@SessionAttributes("editedCon")
public class ContentController extends AppController{

	@Autowired
	IContentService service;

	Utility util;

	private void init() {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		this.util = (Utility) context.getBean("util");
	}

	@RequestMapping(value = "/contents", method = RequestMethod.GET)
	public ModelAndView index(Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			model.addAttribute("content", new Content());
			model.addAttribute("contents", service.listCon());
			return new ModelAndView("contents");
		}

	}

	@RequestMapping(value = "/saveCon", method = RequestMethod.POST)
	public String saveCon(@Valid Content c, BindingResult bindingResult,
			Model model, MultipartFile file) throws IOException {
		if (bindingResult.hasErrors()) {
			model.addAttribute("contents", service.listCon());
			return ("contents");
		}

		if (!file.isEmpty()) {
			BufferedImage bi = ImageIO.read(file.getInputStream());
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		}
		if (c.getIdContent() != null) {
			if (model.asMap().get("editedCon") != null) {
				if (file.isEmpty()) {
					Content us = (Content) model.asMap().get("editedCon");
					// Categorie cat = metier.getCategories(c.getIdcategorie())
					c.setPhoto(us.getPhoto());
				}
			}
			service.modifierCon(c);
		} else
			service.addContent(c);

		model.addAttribute("content", new Content());
		model.addAttribute("contents", service.listCon());
		return "contents";
	}

	@RequestMapping(value = "photoCon", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCon(Long idCon) throws IOException {
		Content c = service.getContent(idCon);
		return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
	}

	@RequestMapping(value = "/delCon")
	public ModelAndView supp(Long idCon, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			service.deleteCon(idCon);
			model.addAttribute("content", new Content());
			model.addAttribute("contents", service.listCon());
			return new ModelAndView("contents");
		}
	}

	@RequestMapping(value = "/editCon")
	public ModelAndView edit(Long idCon, Model model, HttpSession session) {
		init();
		if (util.checkSession(session) == false) {
			return new ModelAndView("redirect:login");
		} else {
			Content c = service.getContent(idCon);
			model.addAttribute("editedCon", c);
			model.addAttribute("content", c);
			model.addAttribute("contents", service.listCon());
			return new ModelAndView("contents");
		}
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("content", new Content());
		mv.addObject("content", service.listCon());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("contents");
		return mv;
	}

}
