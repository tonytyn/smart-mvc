package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	
    	
    }

    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext sc = sce.getServletContext();
    	sc.setAttribute("app", sc.getContextPath());
    	
    }
	
}
