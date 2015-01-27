package org.lztvn.socket;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value="/actions",configurator = GetHttpSessionConfigurator.class)
public class DeviceWebSocketServer {
	private Session wsSession;
	private HttpSession httpSession;
	@OnOpen
	public void open(Session session, EndpointConfig config) {
		this.wsSession = session;
		this.httpSession = (HttpSession) config.getUserProperties()
				.get(HttpSession.class.getName());
		CustomUser user = new CustomUser();
		LZTUserManager.getInstance().getSessionHanler().add(user);
	}
	
	@OnClose
	public void close(Session session) {
	}

	@OnError
	public void onError(Throwable error) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
	}
}    
