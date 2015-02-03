package org.lztvn.elearning;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("lzt-user")
public class HomeController extends AppController{
	public HomeController() {
	}
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, Device device) {
		logger.info("Welcome home! The client locale is {}.", locale);
		//logger.info("Welcome home! The client locale is {}.", model.asMap().get("lzt-user").toString());
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "myapp.homepage";
	}
	
}
