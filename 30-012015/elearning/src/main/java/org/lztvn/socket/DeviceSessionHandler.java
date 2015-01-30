package org.lztvn.socket;

import java.io.IOException;

import javax.websocket.Session;

import org.codehaus.jackson.map.ObjectMapper;

public class DeviceSessionHandler {
	public void sendToSession(Session session,Object object) {
        try {
        	ObjectMapper mapper = new ObjectMapper();
            session.getBasicRemote().sendText(mapper.writeValueAsString(object));
        } catch (IOException ex) {
            //sessions.remove(session);
            //Logger.getLogger(DeviceSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
}
