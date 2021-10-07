package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dao.UserDAO;
import entity.User;

public class Controller {
	@RequestMapping("/listUser.do")
	public String listUser(HttpServletRequest request) {
		UserDAO dao = new UserDAO();
		List<User> list = dao.listUser();
		if(list!=null) {
			request.setAttribute("list", list);
			return "listuser";
		}
		return null;
		
	}
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAO();
		
		if(dao.loginByNAP(username, password)) {
			
			return "redirect:/listUser.do";
		}
		
		return "login";
	}
	@RequestMapping("/addUser-form.do")
	public String addUserForm(HttpServletRequest request) {
		return "adduser";
	}
	@RequestMapping("/addUser.do")
	public String addUser(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		User user = new User(-1,username,password,email);
		
		UserDAO dao = new UserDAO();
		
		if(dao.getUserByUsername(username)) {
			request.setAttribute("msg", "用户名已经存在啦");
			return "adduser";
			
		}
		if(dao.addUser(user)) {
			return "redirect:/listUser.do";
			
		}
		return null;
	}
	@RequestMapping("/delUser.do")
	public String delUser(HttpServletRequest request) {
		
		int id =Integer.parseInt(request.getParameter("id")) ;
		
		UserDAO dao = new UserDAO();
		
		if(dao.delUser(id)) {
			return "redirect:/listUser.do";
			
		}
		return null;
	}
}
