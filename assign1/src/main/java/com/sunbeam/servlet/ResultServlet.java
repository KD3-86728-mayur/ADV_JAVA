package com.sunbeam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.classes.Marks;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	
	ArrayList<Marks> list = null;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		list = new ArrayList<>();
		list.add(new Marks("Java programming", 80.0)); 
		list.add(new Marks("Web programming", 85.0)); 
		list.add(new Marks("Database technologies", 83.0));
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Assignment 1</title>");
		out.print("</head>");
		out.print("<body>");
		
		out.print("<h1>Result:-</h1>");
		out.print("<table>");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>Subject</th>");
		out.print("<th>Marks</th>");
		out.print("</tr>");
		out.print("</thead>");
		out.print("<tbody>");
		 for(Marks m:list) { 
			    out.println("<tr>"); 
			    out.printf("<td>%s<td>\r\n", m.getSubject()); 
			    out.printf("<td>%.2f<td>\r\n", m.getMarks()); 
			    out.println("</tr>"); 
			} 
		 out.print("</tbody>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}


	
}
