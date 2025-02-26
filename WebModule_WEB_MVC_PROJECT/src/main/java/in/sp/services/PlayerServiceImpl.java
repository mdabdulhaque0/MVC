package in.sp.services;

import in.sp.dao.PlayerLoginDao;
import in.sp.dao.PlayerRegisterDao;
import in.sp.model.PlayerLogin;
import in.sp.model.PlayerRegister;

public class PlayerServiceImpl implements Services
{

	@Override
	public boolean regService(PlayerRegister playerRegister) 
	{
		boolean status = false;
		PlayerRegisterDao dao = new PlayerRegisterDao();
		status = dao.playerReg(playerRegister);

		if(status!=false)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public  PlayerLogin loginService(String email , String password) 
	{
		 boolean status = false;
		 PlayerLogin playerLogin = new PlayerLogin();
		 PlayerLoginDao loginDao = new PlayerLoginDao();
		 playerLogin = loginDao.playerLogin(email,password);
		 
		 if(!playerLogin.equals(null))
		 {
			 return playerLogin;
		 }
		 else
		 {
			 return playerLogin;
		 }
		 
	}


}
