package in.sp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import in.sp.model.PlayerRegister;
import in.sp.services.PlayerServiceImpl;
import in.sp.services.Services;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/registerServlet")
public class RegisterController extends HttpServlet 
{
		String name,email,password,city,gender,contact="";
		boolean register_status = false;

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
		{
			RequestDispatcher dispatcher ;
			PrintWriter writer = resp.getWriter();
			name = req.getParameter("user_name");
			email = req.getParameter("user_email");
			password = req.getParameter("user_password");
			city = req.getParameter("user_city");
			gender = req.getParameter("user_gender");
			contact = req.getParameter("user_contact");
			
			
			PlayerRegister playerRegister = new PlayerRegister();
			playerRegister.setName(name);
			playerRegister.setEmail(email);
			playerRegister.setPassword(password);
			playerRegister.setCity(city);
			playerRegister.setGender(gender);
			playerRegister.setContact(contact);
			
			Services service = new PlayerServiceImpl();
			register_status = service.regService(playerRegister);
			
			if(register_status != false)
			{
				resp.setContentType("text/html");
				writer.print("<h3 style='color:navy'> Registration Successful !!");
				dispatcher = req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				resp.setContentType("text/html");
				writer.print("<h3 style='color:red'> Registration Failed !! Please Try Again");
				dispatcher = req.getRequestDispatcher("register.jsp");
				dispatcher.include(req, resp);
			}
			
		}
}
