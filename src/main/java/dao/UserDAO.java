package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DButils;

public class UserDAO {
	
	
	
	public boolean loginByNAP(String username,String password) {//核对用户数据
		String sql = "select * from t_user where username=? and password=?";
		Connection conn = null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try {
			conn=DButils.getconn();
			ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, rs);
		}
		
		return false;
	}
	
	public boolean addUser(User user) {//添加用户数据
		String sql = "insert into t_user values(null,?,?,?) ";
		Connection conn=null;
		PreparedStatement ps =null;
		try {
			conn = DButils.getconn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, null);
		}
		return false;
		
	}
	public boolean delUser(int id) {//删除用户数据
		String sql = "delete from t_user where id=?";
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn=DButils.getconn();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, null);
		}
		return false;
	}
	
	public boolean getUserByUsername(String username) {//查询用户是否存在
		String sql = "select * from t_user where username = ? ";
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = DButils.getconn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, rs);
		}
		return false;
	}
	
	public List<User> lietUser() {//列出所有用户
		String sql = "select * from t_user ";
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<User>list = new ArrayList<User>();
		try {
			conn = DButils.getconn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				list.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			DButils.close(conn, ps, rs);
		}
		return list;
	}
	
	
}
