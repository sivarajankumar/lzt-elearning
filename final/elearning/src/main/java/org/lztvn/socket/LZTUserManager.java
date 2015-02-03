package org.lztvn.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Session;

import org.codehaus.jackson.map.ObjectMapper;
import org.lztvn.entity.User;
import org.lztvn.service.IUserService;
import org.lztvn.socket.Device;
import org.lztvn.unityclass.MessageUnity;
import org.lztvn.unityclass.SocketObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LZTUserManager {
	@Autowired
	public IUserService userService;
	private List<Device> sessionHanler;
	private static LZTUserManager singleton = new LZTUserManager( );

	/* A private Constructor prevents any other 
	 * class from instantiating.
	 */
	private LZTUserManager(){
		sessionHanler = new ArrayList<Device>();	
	}
	public List<Device> getSessionHanler() {
		return sessionHanler;
	}
	public void setSessionHanler(List<Device> sessionHanler) {
		this.sessionHanler = sessionHanler;
	}
	/* Static 'instance' method */
	public static LZTUserManager getInstance( ) {
		return singleton;
	}
	public void addDevice(Device device){
		int index = -1;
		for (Device item : sessionHanler) {
			if(item.getUser().getId() == device.getUser().getId()){
				index = sessionHanler.indexOf(item);
				break;
			}	
		}
		if(index!=-1){
			sessionHanler.remove(index);
		}
		this.sessionHanler.add(device);
	}
	public void removeDeviceBySession(Session session){
		int index = -1;
		for (Device item : sessionHanler) {
			if(item.getSession() == session){
				index = sessionHanler.indexOf(item);
				break;
			}	
		}
		if(index!=-1){
			sessionHanler.remove(index);
		}

	}
	public Session getSessionByUserId(Long id){
		for (Device item : sessionHanler) {
			if(item.getUser().getId() == id){
				return item.getSession();
			}	
		}
		return null;
	};
	public void sendMessage(MessageUnity message){
		Session session = this.getSessionByUserId(Long.parseLong(message.getToUser()));
		SocketObject socketObject = new SocketObject();
		socketObject.setMethod("sendMessage");
		socketObject.setObj(message);
		this.sendToSession(session, socketObject);
	};
	/*core not remove*/
	public void sendToSession(Session session,Object object) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			session.getBasicRemote().sendText(mapper.writeValueAsString(object));
		} catch (IOException ex) {
			this.removeDeviceBySession(session);
		}
	}
	public User getUserBySession(Session session) {
		for (Device item : sessionHanler) {
			if(item.getSession() == session){
				return item.getUser();
			}	
		}
		return null;
	}
}
