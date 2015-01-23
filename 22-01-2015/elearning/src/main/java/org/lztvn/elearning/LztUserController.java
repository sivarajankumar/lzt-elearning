package org.lztvn.elearning;

import java.util.List;
import java.util.Locale;

import org.lztvn.entity.Message;
import org.lztvn.entity.User;
import org.lztvn.service.IMessageService;
import org.lztvn.service.IUserService;
import org.lztvn.unityclass.MessageUnity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("lzt-user")
public class LztUserController extends AppController{
	@Autowired
	IUserService userService;
	@Autowired
	IMessageService messageService;
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Locale locale, Model model){
		if(model.asMap().get("lzt-user")!=null){  
        User user=(User)model.asMap().get("lzt-user");   
        List<User> lstUser = userService.getAllUserExceptMe(user);
        List<Message> lstMessage = userService.getMessageNotifyToMe(user);
		model.addAttribute("lstUser", lstUser);
		model.addAttribute("lstMessage",lstMessage);
        }  
		return "lztuser/mypage";
	}
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public  Object sendMessage(@RequestBody MessageUnity message,Model model) {	
		if(model.asMap().get("lzt-user")!=null){  
	        User user=(User)model.asMap().get("lzt-user");   
	        if(message.getMessage()!=null && message.getMessage()!=""){
				Message mes = new Message(user.getId(),Long.valueOf(message.getToUser()).longValue(), message.getMessage());
				messageService.addMessage(mes);
			}
	    }  
		return message;			
    }
}
