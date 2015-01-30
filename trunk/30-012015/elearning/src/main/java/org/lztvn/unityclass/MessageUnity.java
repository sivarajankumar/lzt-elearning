package org.lztvn.unityclass;

import java.io.Serializable;

public class MessageUnity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String toUser;
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
