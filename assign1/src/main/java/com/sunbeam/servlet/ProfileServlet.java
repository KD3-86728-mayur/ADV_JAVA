package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Assignment 1</title>");
		out.print("</head>");
		out.print("<body bgcolor='pink'>");
		out.print("<h2>Name : Mayur Pawar</h2>");
		out.print("<h2>Qualification : Btech Computer Engineer</h2>");
		out.print("<h2>College : Dr.Babasaheb Ambedkar Technological University Lonere</h2>");
		out.print("<h2>DOB : 09/08/2002</h2>");
		out.print("</body>");
		out.print("</html>");
	}

}
