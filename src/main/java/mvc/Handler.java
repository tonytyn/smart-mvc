package mvc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class Handler {
	private Controller controller;
	private Method method;
	public Handler(Controller controller, Method method) {
		this.controller = controller;
		this.method = method;
	}
	public String execute(HttpServletRequest request)  {
		String path=null;
		try {
			path =  (String)method.invoke(controller, request);
			
		} catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			e.printStackTrace();
		}
		return path;
	}
}
