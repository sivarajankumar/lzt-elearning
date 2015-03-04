package org.lztvn.elearning.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class Utility {
	
	 public boolean checkSession(HttpSession session){
		   if(session.getAttribute("userLogin")!=null)
		     return true;
		   else
			 return false;
	   }
	 
	 public boolean checkFrontSession(HttpSession session){
		   if(session.getAttribute("userFLogin")!=""&&session.getAttribute("userFLogin")!=null)
		     return true;
		   else
			 return false;
	   }
}
