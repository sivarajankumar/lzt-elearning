package org.lztvn.elearning.front_controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.lztvn.elearning.controllers.AppController;
import org.lztvn.elearning.entities.Contact;
import org.lztvn.elearning.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController extends AppController{
	
	@Autowired
	IContactService serviceContact;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
    public ModelAndView contact(Model model){
		model.addAttribute("contactForm", new Contact());
		//model.addAttribute("user", new User());
    	return new ModelAndView("contact");
    }
	
	
	@RequestMapping(value = "/SendMessage", method = RequestMethod.POST)
	public String SendMessage(@Valid Contact c,Model model, BindingResult bindingResult) throws IOException{
		if (bindingResult.hasErrors()) {
			model.addAttribute("contactForm", new Contact());
			return ("contact");
		}
        serviceContact.addContact(c);
		
		model.addAttribute("Send_success", "Message is sent successfully, our team will answer your question, Thank you !");
		return "message_success";
	}
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("contact", new Contact());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("contact");
		return mv;
	}


}
