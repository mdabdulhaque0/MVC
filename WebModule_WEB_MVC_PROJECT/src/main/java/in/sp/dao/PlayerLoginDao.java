package in.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.sp.model.PlayerLogin;
import in.sp.model.PlayerRegister;

public class PlayerLoginDao 
{
	DbConnection connection = new DbConnection();
	public PlayerLogin playerLogin(String email , String password) 
	{
		PlayerLogin playerLogin = null;
		try 
		{
			Connection con = connection.getConnection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM players WHERE email = ? AND password = ?");
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet resultSet = statement.executeQuery();
			if(resultSet != null)
			{
				playerLogin = new PlayerLogin();

				while(resultSet.next())
				{
					playerLogin.setName(resultSet.getString("name"));
					playerLogin.setEmail(resultSet.getString("email"));
					playerLogin.setPassword(resultSet.getString("password"));
					playerLogin.setGender(resultSet.getString("gender"));
					playerLogin.setCity(resultSet.getString("city"));
					playerLogin.setContact(resultSet.getString("contact"));
				}
				return playerLogin;
			}
			else
			{
				return playerLogin;
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return playerLogin;
		}
		
	}
}
