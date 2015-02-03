package org.lztvn.elearning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.lztvn.entity.Message;
import org.lztvn.entity.User;
import org.lztvn.service.IMessageService;
import org.lztvn.service.IUserService;
import org.lztvn.socket.LZTUserManager;
import org.lztvn.unityclass.MessageUnity;
import org.lztvn.unityclass.RoleLZT;
import org.lztvn.unityclass.UserOutDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("lzt-user")
@Scope("session")
public class LztUserController extends AppController{
	@Autowired
	IUserService userService;
	@Autowired
	IMessageService messageService;
	public LztUserController(){
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(RoleLZT.Admin.getValue());lst.add(RoleLZT.Student.getValue());lst.add(RoleLZT.Teacher.getValue());lst.add(RoleLZT.User.getValue());
		/*begin role for action home*/
		map.put("mypage", lst);
		/*end*/
		/*begin role for action home*/
		map.put("sendMessage", lst);
		/*end*/
		this.roles = map;
	}
	@RequestMapping(value="/mypage",method=RequestMethod.GET)
	public String mypage(Locale locale, Model model){
		if(model.asMap().get("lzt-user")!=null){  
        User user=(User)model.asMap().get("lzt-user");   
        List<User> lstUser = userService.getAllUserExceptMe(user);
        List<Message> lstMessage = userService.getMessageNotifyToMe(user);
		model.addAttribute("lstUser", lstUser);
		model.addAttribute("lstMessage",lstMessage);
        }  
		return "myapp.mypage";
	}
	@RequestMapping(value="/sendMessage", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public  Boolean sendMessage(@RequestBody MessageUnity message,Model model) {	
		if(model.asMap().get("lzt-user")!=null){  
	        User user=(User)model.asMap().get("lzt-user");   
	        if(message.getMessage()!=null && message.getMessage()!=""){
				Message mes = new Message(user.getId(),Long.valueOf(message.getToUser()).longValue(), message.getMessage());
				messageService.addMessage(mes);
				message.setFromUser(String.valueOf(user.getId()));
				LZTUserManager.getInstance().sendMessage(message);
				return true;
	        }
	        
	    }  
		return false;			
    }
	@RequestMapping(value="/getAllUser", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public  Object getAllUser(Model model) {	
		List<UserOutDC> lst= new ArrayList<UserOutDC>();
		if(model.asMap().get("lzt-user")!=null){  
	        User user=(User)model.asMap().get("lzt-user");   
	        List<User> lstUser = userService.getAllUserExceptMe(user);
			for (User usr : lstUser) {
				UserOutDC item = new UserOutDC();
				item.setId(usr.getId());
				item.setName(usr.getFirstName());
				lst.add(item);
			}
			return lst;
	     }  
		return null;			
    }
}
