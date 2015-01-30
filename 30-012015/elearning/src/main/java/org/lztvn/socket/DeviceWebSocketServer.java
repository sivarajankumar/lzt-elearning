package org.lztvn.socket;


import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.codehaus.jackson.map.ObjectMapper;
import org.lztvn.unityclass.SocketObject;

@ServerEndpoint(value="/actions",configurator = GetHttpSessionConfigurator.class)
public class DeviceWebSocketServer {
	private Session wsSession;
	private HttpSession httpSession;
	@OnOpen
	public void open(Session session, EndpointConfig config) {
		this.wsSession = session;
		this.httpSession = (HttpSession) config.getUserProperties()
				.get(HttpSession.class.getName());
		Device device = new Device(this.wsSession,this.httpSession);
		if(device.getUser().getId()> 0){
		LZTUserManager.getInstance().addDevice(device);
		}
	}
	
	@OnClose
	public void close(Session session) {
		LZTUserManager.getInstance().removeDeviceBySession(session);
	}

	@OnError
	public void onError(Throwable error) {
	}

	@OnMessage
	public void handleMessage(String message, Session session) {
		//StaticMethod.call(methodName, parObj);
		try {
			@SuppressWarnings("unused")
			SocketObject garima = new ObjectMapper().readValue(message, SocketObject.class);
		}  catch (Exception e) {
			LZTUserManager.getInstance().removeDeviceBySession(session);
			e.printStackTrace();
		}
	}
	
}    
