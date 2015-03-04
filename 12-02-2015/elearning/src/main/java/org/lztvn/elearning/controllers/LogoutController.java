package org.lztvn.elearning.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController extends AppController{
   @RequestMapping(value="/logout")
   public ModelAndView logout(HttpSession session){
	   session.invalidate();
	  // session.setAttribute("userLogin", null);
	   //request.removeAttribute("userLogin", WebRequest.SCOPE_SESSION);
	   return new ModelAndView("redirect:login");
   }
}
