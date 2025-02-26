package in.sp.services;

import in.sp.model.PlayerLogin;
import in.sp.model.PlayerRegister;

public interface Services 
{
	public boolean regService(PlayerRegister playerRegister);
	public PlayerLogin loginService(String email , String password);
}
