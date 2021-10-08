package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset = utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO dao = new UserDAO();
		boolean flag = dao.login(username, password);
		if(flag) {
			request.getSession().setAttribute("user", username);
			response.getWriter().write("登录成功");
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			request.getRequestDispatcher("/ums/login.jsp").forward(request, response);
			
		}
	}

}
