package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

/**
 * 列出所有用户信息的servlet
 */
public class ListUserServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.解决发送及响应乱码问题
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2.调用dao里的方法，获取响应数据,
		UserDAO dao = new UserDAO();
		List<User> list = dao.listUser();
		//3.将结果数据绑定到request
		request.setAttribute("list", list);
		//4.获取请求转发器并转发
		request.getRequestDispatcher("/WEB-INF/jsp/listuser.jsp").forward(request, response);
	}

}
