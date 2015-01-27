package org.lztvn.socket;

import java.io.IOException;

import javax.websocket.Session;

public class DeviceSessionHandler {
	public void sendToSession(Session session, String jsonMessage) {
        try {
            session.getBasicRemote().sendText(jsonMessage);
        } catch (IOException ex) {
            //sessions.remove(session);
            //Logger.getLogger(DeviceSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
