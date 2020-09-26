package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class DelUserServlet
 */
public class DelUserServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		if(dao.delUser(id)) {
			//request.getRequestDispatcher("/WEB-INF/jsp/listuser.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath()+"/ums/listuser");
		}else {
			response.getWriter().write("删除失败啦");
		}
	}

}
