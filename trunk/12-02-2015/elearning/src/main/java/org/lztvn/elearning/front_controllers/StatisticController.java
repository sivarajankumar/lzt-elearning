package org.lztvn.elearning.front_controllers;

import org.lztvn.elearning.controllers.AppController;
import org.lztvn.elearning.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StatisticController extends AppController{
	@RequestMapping(value="/statistic",method = RequestMethod.GET)
	   public ModelAndView profile(Model model){
		   model.addAttribute("user", new User());
		   return new ModelAndView("statistic");
	   }
}
