package in.sp.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebServlet;

@WebFilter(urlPatterns = {"/registerServlet"} , filterName =  "regFilter")
public class RegistrationFilter implements Filter
{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain fc) throws IOException, ServletException 
	{
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		String gender = req.getParameter("user_gender");
		String contact = req.getParameter("user_contact");
		String city = req.getParameter("user_city");

		if(name.length() < 3)
		{
			out.println("<h2 style='color:red'> Invalid Name Entry</h2>");			
		}
		else if(!email.endsWith("@gmail.com"))
		{
			out.println("<h2 style='color:red'> Invalid Email Entry</h2>");			
		}
		else if(contact.length() != 10)
		{
			out.println("<h2 style='color:red'> Invalid Contact Entry</h2>");			
		}
		else if(city.length() < 3)
		{
			out.println("<h2 style='color:red'> Invalid City Entry</h2>");			
		}
		else if(password.length() < 4)
		{
			out.println("<h2 style='color:red'> Invalid Password Entry</h2>");			
		}
		else if(gender.length() > 7)
		{
			out.println("<h2 style='color:red'> Invalid Gender Entry</h2>");			
		}
		else
		{
			fc.doFilter(req, resp);
		}
	}

}
