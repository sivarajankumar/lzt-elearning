package org.lztvn.elearning.controllers;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lztvn.elearning.entities.Role;
import org.lztvn.elearning.entities.User;
import org.lztvn.elearning.service.IUserRoleService;
import org.lztvn.elearning.service.IUserService;
import org.lztvn.elearning.unityclass.RoleLZT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	IUserRoleService service;
	@Autowired
	IUserService userService;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			Class<?> clazz = Class.forName(((HandlerMethod)handler).getBean().getClass().getName());
			Constructor<?> cons = clazz.getConstructor();
			AppController object = (AppController) cons.newInstance();
			String methodName =((HandlerMethod) handler).getMethod().getName();
			//false if it is ajax request unauthorize
			if(!this.checkAuthen(request, response, object.roles,methodName)){
				return false;
			};
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (handler instanceof HandlerMethod) {
			HttpSession session = request.getSession(false);
			if (modelAndView != null && session!=null) {
				User user = (User)session.getAttribute("userFLogin");
				if(user!=null){
				modelAndView.getModelMap().
				addAttribute("lztuser",user);
				modelAndView.getModelMap().
				addAttribute("notify",userService.getAllNotify(user));
				}
			}
		}


	}

	public Boolean  checkAuthen(HttpServletRequest request,
			HttpServletResponse response,Map<String, List<Integer>> config,String key){
		HttpSession session = request.getSession(false);
		//if not exit key for config make it public for everyone
		if(config!=null && config.get(key) != null){
			if(session==null){
				if(!config.get(key).contains(RoleLZT.NonUser.getValue())){
					try {
						if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ){
							// include other file
							response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
							return false;
						}else{
						response.sendRedirect("/elearning/lstcourses/login");
						return true;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				User user = (User)session.getAttribute("userLogin");
				if(user==null){
					user = (User)session.getAttribute("userFLogin");
				}
				if(user==null){
					if(!config.get(key).contains(RoleLZT.NonUser.getValue())){
						try {
							if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ){
								// include other file
								response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
								return false;
							}else{
							response.sendRedirect("/elearning/lstcourses/login");
							return true;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					List<Role> lst = service.getRoleByUser(user);
					if(lst==null){
						try {
							if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ){
								// include other file
								response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
								return false;
							}else{
							response.sendRedirect("/elearning/lstcourses/login");
							return true;
							}
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}else{
						Boolean hasRole = false;
						for (Role role : lst) {
							if(config.get(key).contains(role.getValue())){
								hasRole = true;
								break;
							}
						}
						if(!hasRole){
							try {
								if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With")) ){
									// include other file
									response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
									return false;
								}else{
								response.sendRedirect("/elearning/lstcourses/login");
								return true;
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
		return true;
	}
}
