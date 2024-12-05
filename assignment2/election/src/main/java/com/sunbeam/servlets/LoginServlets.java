package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;


@WebServlet("/login")
public class LoginServlets extends HttpServlet  {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req,resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//get email and password from index.html
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			// call uderdao method to get user by email 
			UserDao udao = new UserDaoImpl();
			User u= udao.findByEmail(email);
			//check if user is valid or not
			if(u != null && u.getPassword().equals(password)) {
				
				Cookie c = new Cookie("uname", u.getFirstName());
				resp.addCookie(c);
				Cookie c2 = new Cookie("role", u.getRole());
				resp.addCookie(c2);
				
				
				HttpSession session = req.getSession();
				session.setAttribute("curUser", u);
				
				if(u.getRole().equals("admin")) {
					resp.sendRedirect("result");
				}else {
					resp.sendRedirect("candlist");
				}
			}else {
				resp.setContentType("text/html");
				PrintWriter out = resp.getWriter();
				out.print("<html>");
				out.print("<head>");
				out.print("<title> Election Application</title>");
				out.print("</head>");
				ServletContext app1 = this.getServletContext();
				String appbg= app1.getInitParameter("app1.bg");
				out.printf("<body bgcolor='%s'>",appbg);
				out.print("<h1>Login Failed</h1>");
				out.print("<h2>Invalid username and password</h2>");
				out.print("<h><a href=\"index.html\">Login Again</a></h>");
				out.print("</body>");
				out.print("</html>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
