package mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


public class DispatcherServlet extends HttpServlet {
	
	private HandlerMapping hm;
	
	@Override
	public void init() throws ServletException {
		
		try {
			hm = new HandlerMapping();
			SAXReader reader = new SAXReader();
			Document doc = reader.read(getClass().getClassLoader().getResourceAsStream("mvc.xml"));
			Element root = doc.getRootElement();
			List<Element> list = root.elements("bean");
			for (Element element : list) {
				String className = element.attributeValue("class");
				System.out.println(className);
				hm.parseController(className);
				
			}
		} catch (Exception e) {
			
		}
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String uri = request.getRequestURI();
			uri = uri.substring(request.getContextPath().length());
			Handler hd = hm.getHandler(uri);
			String path = hd.execute(request);
			System.out.println(path);
			if(path.startsWith("redirect:")) {
				path=path.substring("redirect:".length());
				if(path.startsWith("http")) {
					response.sendRedirect(path);
				}else {
					response.sendRedirect(request.getContextPath()+path);
					
				}
			}else {
				path = "/WEB-INF/jsp/"+path+".jsp";
				request.getRequestDispatcher(path).forward(request, response);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
