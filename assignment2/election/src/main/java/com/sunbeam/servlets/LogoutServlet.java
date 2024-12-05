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

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/type");
		PrintWriter out = resp.getWriter();
		Cookie c = new Cookie("uname","");
		resp.addCookie(c);
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		Cookie c1 = new Cookie("role", "");
		resp.addCookie(c1);
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Election</title>");
		out.print("</head>");
		ServletContext app1 = this.getServletContext();
		String appbg= app1.getInitParameter("app1.bg");
		out.printf("<body bgcolor='%s'>",appbg);
		out.print("<h1>LOgout Successfully...!</h1>");
		out.print("<h1><a href='index.html'>Login</a></h1>");
		out.print("</body>");
		out.print("</html>");
		
	}

	
	
}
