package org.lztvn.socket;

import java.util.ArrayList;
import java.util.List;

public class LZTUserManager extends DeviceSessionHandler{
	private List<CustomUser> sessionHanler;
	private static LZTUserManager singleton = new LZTUserManager( );

	/* A private Constructor prevents any other 
	 * class from instantiating.
	 */
	private LZTUserManager(){
	sessionHanler = new ArrayList<CustomUser>();	
	}
	public List<CustomUser> getSessionHanler() {
		return sessionHanler;
	}
	public void setSessionHanler(List<CustomUser> sessionHanler) {
		this.sessionHanler = sessionHanler;
	}
	/* Static 'instance' method */
	public static LZTUserManager getInstance( ) {
		return singleton;
	}
}
