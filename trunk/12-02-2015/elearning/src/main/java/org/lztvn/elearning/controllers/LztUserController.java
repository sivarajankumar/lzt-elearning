package org.lztvn.elearning.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.lztvn.elearning.entities.Friend;
import org.lztvn.elearning.entities.Message;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.IFriendService;
import org.lztvn.elearning.service.IMessageService;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.socket.LZTUserManager;
import org.lztvn.elearning.unityclass.CommonObj;
import org.lztvn.elearning.unityclass.MessageUnity;
import org.lztvn.elearning.unityclass.RequestFriendUnity;
import org.lztvn.elearning.unityclass.RoleLZT;
import org.lztvn.elearning.unityclass.UserOutDC;
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
@SessionAttributes("userFLogin")
@Scope("session")
public class LztUserController extends AppController{
	@Autowired
	IUserService userService;
	@Autowired
	IMessageService messageService;
	@Autowired
	IFriendService friendService;
	public LztUserController(){
		Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(RoleLZT.Admin.getValue());lst.add(RoleLZT.Student.getValue());lst.add(RoleLZT.Teacher.getValue());lst.add(RoleLZT.User.getValue());
		/*begin role for action home*/
		//map.put("mypage", lst);
		/*end*/
		/*begin role for action home*/
		//map.put("sendMessage", lst);
		map.put("addFriend", lst);
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
		if(model.asMap().get("userFLogin")!=null){  
	        User user=(User)model.asMap().get("userFLogin");   
	        if(message.getMessage()!=null && message.getMessage()!=""){
				Message mes = new Message(user.getIdUser(),Long.valueOf(message.getToUser()).longValue(), message.getMessage());
				messageService.addMessage(mes);
				message.setFromUser(String.valueOf(user.getIdUser()));
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
		if(model.asMap().get("userFLogin")!=null){  
	        User user=  (User) model.asMap().get("userFLogin");   
	        List<User> lstUser = new ArrayList<User>();
	        lstUser = userService.getAllUserExceptMe(user);
			for (User usr : lstUser) {
				UserOutDC item = new UserOutDC();
				item.setId(usr.getIdUser());
				item.setName(usr.getFirstName());
				lst.add(item);
			}
			return lst;
	     }  
		return null;			
    }
	
	@RequestMapping(value="/friendNotify", method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public  Object friendNotify(Model model) {	
		if(model.asMap().get("userFLogin")!=null){  
			 User user=  (User) model.asMap().get("userFLogin");   
			 return friendService.getAllRequestFriend(user);
		}
		return null;			
    }
	
	@RequestMapping(value="/addFriend", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public  Object addFriend(@RequestBody RequestFriendUnity friend,Model model) {	
		Friend friendTemplate = new Friend();
		friendTemplate.setToUser(Long.parseLong(friend.getToUser()));
		if(model.asMap().get("userFLogin")!=null){  
			 User user=  (User) model.asMap().get("userFLogin");   
			 friendTemplate.setFromUser(user.getIdUser());
			 LZTUserManager.getInstance().NotifyFriendRequest(friendTemplate);
		}
		friendService.addFriend(friendTemplate);
		CommonObj obj =  new CommonObj();
		obj.success = true;
		return obj;			
    }
}
