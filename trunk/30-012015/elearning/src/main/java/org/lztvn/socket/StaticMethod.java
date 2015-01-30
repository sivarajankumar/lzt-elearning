package org.lztvn.socket;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StaticMethod {
	public static String call(String methodName, String parObj) {
		String val = null;
		Class<StaticMethod> mClass = StaticMethod.class;
		try {
			Method method = mClass.getMethod(methodName, String.class);
			try {
				val = (String) method.invoke(null, new Object[] { parObj });
				return val;
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}
	/*example*/
	public static String Login(String paraObj) {
		
		return paraObj;
	}
}
