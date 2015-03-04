package org.lztvn.elearning.unityclass;

import java.io.Serializable;

public class MessageUnity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String toUser;
	private String fromUser;
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	private String message;
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
