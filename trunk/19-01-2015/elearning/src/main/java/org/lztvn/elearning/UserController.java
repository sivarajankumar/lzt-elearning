package org.lztvn.elearning;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@RequestMapping(value = "/login1", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "login";
	}

}
