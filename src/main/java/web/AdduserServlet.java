package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;


public class AdduserServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//解决接收和响应的中文问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//获取jsp发过来的参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		//创建user对象，并将获得的参数赋值给他
		User user = new User(-1,username,password,email);
		UserDAO dao = new UserDAO();
		if(dao.getUserByUsername(username)) {
			request.setAttribute("msg", "用户名重复了啊");
			RequestDispatcher rd = request.getRequestDispatcher("/ums/adduser.jsp");
			rd.forward(request, response);
			
		}else {
			if(dao.addUser(user)) {
				response.sendRedirect(request.getContextPath()+"/ums/listuser");
				
			}else {
				request.setAttribute("msg", "操作失败");
				request.getRequestDispatcher("/ums/adduser.jsp").forward(request, response);
			
			}
		}
	}

}
