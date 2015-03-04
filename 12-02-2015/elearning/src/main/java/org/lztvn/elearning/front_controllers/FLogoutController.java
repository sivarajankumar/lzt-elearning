package org.lztvn.elearning.front_controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.lztvn.elearning.controllers.AppController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FLogoutController extends AppController{
   @RequestMapping(value="/lstcourses/flogout")
   public ModelAndView logout(HttpServletRequest request){
	   HttpSession session=request.getSession();  
	   session.removeAttribute("userFLogin");
//       session.invalidate();

	   return new ModelAndView("redirect:login");
   }
}
