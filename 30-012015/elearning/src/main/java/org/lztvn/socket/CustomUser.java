package org.lztvn.socket;

import javax.websocket.Session;

import org.lztvn.entity.User;

public class CustomUser {
 private User user;
 private Session session;
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
