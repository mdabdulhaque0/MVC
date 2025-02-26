package in.sp.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DbConnection {

	public Connection getConnection() throws Exception 
	{
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/web_mvc_demo";
		String user = "root";
		String password ="root";
		 
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setURL(url);
			Connection con = dataSource.getConnection(user, password);
			return con;
		
	}
}
