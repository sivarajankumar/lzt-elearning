package org.lztvn.elearning;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lztvn.entity.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppController extends HandlerInterceptorAdapter{
	public List<Role> roles;
	public static final Logger logger = LoggerFactory.getLogger(AppController.class);
	@Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
    	HttpSession session = request.getSession(false);
    	if(session!=null){
		//User user = (User)session.getAttribute("lzt-user");
    	}
       return super.preHandle(request, response, handler);
    }
 
    //@Override
    //public void postHandle(HttpServletRequest request,
    //       HttpServletResponse response, Object handler,
    //        ModelAndView modelAndView) throws Exception {
    //}
 
   // @Override
   // public void afterCompletion(HttpServletRequest request,
   //         HttpServletResponse response, Object handler, Exception ex)
    //        throws Exception {
    //}
}
