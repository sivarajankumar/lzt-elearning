package org.lztvn.elearning;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.lztvn.entity.Role;
import org.lztvn.entity.User;
import org.lztvn.service.IUserRoleService;
import org.lztvn.unityclass.RoleLZT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AppInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	IUserRoleService service;
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			Class<?> clazz = Class.forName(((HandlerMethod)handler).getBean().getClass().getName());
			Constructor<?> cons = clazz.getConstructor();
			AppController object = (AppController) cons.newInstance();
			String methodName =((HandlerMethod) handler).getMethod().getName();
			this.checkAuthen(request, response, object.roles,methodName);
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
				User user = (User)session.getAttribute("lzt-user");
				modelAndView.getModelMap().
				addAttribute("lztuser",user);
			}
		}

	}

	public void  checkAuthen(HttpServletRequest request,
			HttpServletResponse response,Map<String, List<Integer>> config,String key){
		HttpSession session = request.getSession(false);
		//if not exit key for config make it public for everyone
		if(config!=null && config.get(key) != null){
			if(session==null){
				if(!config.get(key).contains(RoleLZT.NonUser.getValue())){
					try {
						response.sendRedirect("/elearning/user/index");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}else{
				User user = (User)session.getAttribute("lzt-user");
				if(user==null){
					if(!config.get(key).contains(RoleLZT.NonUser.getValue())){
						try {
							response.sendRedirect("/elearning/user/index");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}else{
					List<Role> lst = service.getRoleByUser(user);
					if(lst==null){
						try {
							response.sendRedirect("/elearning/user/index");
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
								response.sendRedirect("/elearning/user/index");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
