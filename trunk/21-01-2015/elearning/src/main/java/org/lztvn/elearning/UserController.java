package org.lztvn.elearning;

import java.util.Locale;





import org.lztvn.entity.User;
import org.lztvn.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

@Controller
@RequestMapping(value = "/user")
@SessionAttributes("lzt-user")
public class UserController extends AppController{
	@Autowired
	IUserService service;
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		model.addAttribute("user",new User());
		return "user/login";
	}
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	public String login(Locale locale, Model model,User user) {		
		User u = service.login(user.getFirstName(), user.getPassword());
		if(u!=null){
			model.addAttribute("lzt-user",u);
			return "redirect:/";
		}else{
			model.addAttribute("user",user);
			return "user/login";
		}
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model,WebRequest request, SessionStatus status) {		
		status.setComplete();
	    request.removeAttribute("lzt-user", WebRequest.SCOPE_SESSION);
        return "redirect:/";
	}
}
