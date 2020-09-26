package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DButils {
	private static BasicDataSource dataSource;
	static {
		Properties prop = new Properties();
		InputStream in = DButils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			prop.load(in);
			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");
			int initialSize = Integer.parseInt(prop.getProperty("initialSize"));
			int MaxActive = Integer.parseInt(prop.getProperty("MaxActive"));
			dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driver);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			dataSource.setInitialSize(initialSize);
			dataSource.setMaxActive(MaxActive);

		} catch (IOException e) {

		}

	}

	public static Connection getconn() throws SQLException {
		return dataSource.getConnection();
	}
	public static void close(Connection conn,PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					rs.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
	}
}
