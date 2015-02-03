package org.lztvn.elearning;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mobile.device.Device;

public class AppController{
	public static final Logger logger = LoggerFactory.getLogger(AppController.class);
	public Map<String, List<Integer>> roles;
	public Boolean isMobile(Device device){
		if (device.isMobile()) {
            return true;
        } else if (device.isTablet()) {
            return true;
        } else {
            return false;      
        }
	};
}
