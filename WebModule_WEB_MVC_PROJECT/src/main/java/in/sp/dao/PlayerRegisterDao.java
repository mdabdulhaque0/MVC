package in.sp.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.sp.model.PlayerRegister;

public class PlayerRegisterDao 
{
	public boolean playerReg(PlayerRegister playerRegister) 
	{
			DbConnection Dbcon = new DbConnection();
		try
		{
			Connection con = Dbcon.getConnection();			
			con.setAutoCommit(false);
			PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO PLAYERS VALUES(?,?,?,?,?,?)");
			preparedStatement.setString(1, playerRegister.getName());
			preparedStatement.setString(2, playerRegister.getEmail());
			preparedStatement.setString(3, playerRegister.getPassword());
			preparedStatement.setString(4, playerRegister.getCity());
			preparedStatement.setString(5, playerRegister.getGender());
			preparedStatement.setString(6, playerRegister.getContact());

			int i = preparedStatement.executeUpdate();
			
			if(i > 0)
			{
				con.commit();
				return true;
			}
			else
			{
				con.rollback();
				return false;
			}
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
			return false;
		}
	
	}
		
		
		
	

}
