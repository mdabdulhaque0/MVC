package in.sp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import in.sp.model.PlayerLogin;
import in.sp.services.PlayerServiceImpl;
import in.sp.services.Services;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginController extends HttpServlet
{
	String email,password="";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		RequestDispatcher dispatcher ;
		PrintWriter writer = resp.getWriter();
		HttpSession session = req.getSession();
		email = req.getParameter("user_email");
		password = req.getParameter("user_password");
		
		
		PlayerLogin playerLogin = new PlayerLogin();
		Services services = new PlayerServiceImpl();
		playerLogin = services.loginService(email,password);
		if(playerLogin.getEmail()!=null)
		{
			session.setAttribute("user_name", playerLogin.getName());
			session.setAttribute("user_email", playerLogin.getEmail());
			session.setAttribute("user_password", playerLogin.getPassword());
			session.setAttribute("user_gender", playerLogin.getGender());
			session.setAttribute("user_city", playerLogin.getCity());
			session.setAttribute("user_contact", playerLogin.getContact());
			dispatcher = req.getRequestDispatcher("profile.jsp");
			dispatcher.forward(req, resp);
		}
		else
		{
			resp.setContentType("text/html");
			writer.print("<h3 style='color:Red'> Login Failed !! Please Try Again");
			dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
		
	}

}
