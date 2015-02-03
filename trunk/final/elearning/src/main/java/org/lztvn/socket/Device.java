package org.lztvn.socket;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.lztvn.entity.User;

public class Device {
	private User user;
	private Session session;

	public Device(){
		
	}
	public Device(Session session, HttpSession httpSession) {
		User user = (User)httpSession.getAttribute("lzt-user");
		if(user!=null){
			this.user = user;
		}
		this.session = session;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
}
