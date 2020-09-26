package mvc;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Handler> mapping = new HashMap<String, Handler>();
	
	public void parseController(String className) throws InstantiationException, Exception {
		try {
			Class cls = Class.forName(className);
			Controller controller = (Controller) cls.newInstance();
			Method[] ms = cls.getDeclaredMethods();
			
			for (Method method : ms) {
				RequestMapping anno = method.getAnnotation(RequestMapping.class);
				if(anno!=null) {
					String url = anno.value();
					Handler handler = new Handler(controller, method);
					mapping.put(url, handler);
					
				}
				
			}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	public Handler getHandler(String url) {
		
		return mapping.get(url);
	}
}
