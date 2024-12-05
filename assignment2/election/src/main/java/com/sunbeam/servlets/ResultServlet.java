package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/result")
public class ResultServlet extends HttpServlet{

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
		
		List<Candidate> list = new ArrayList<>();
		
		try {
			CandidateDao cdo = new CandidateDaoImpl();
			list = cdo.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title> Election Result</title>");
		out.print("</head>");
		ServletContext app1 = this.getServletContext();
		String appbg= app1.getInitParameter("app1.bg");
		out.printf("<body bgcolor='%s'>",appbg);
		
		Cookie[] arr = req.getCookies();
		String un = "";
		String rl = "";
		
		for(Cookie c : arr) {
			if(c.getName().equals("uname")) {
				un =  c.getValue();
			}
			
			if(c.getName().equals("role"))
			{
				rl =  c.getValue();
			}
		}
		out.printf("<h3>Hello, %s [%s]</h3>",un,rl);
		
		ServletContext ctx = req.getServletContext();
		String annou = (String) ctx.getAttribute("annous");
		if(annou != null) {
			out.print("<p>"+annou+"</p>");
		}
		out.print("<table>");
		out.print("<thead>");
		out.print("<tr>");
		out.print("<th>Id</th>");
		out.print("<th>Name</th>");
		out.print("<th>Party</th>");
		out.print("<th>Vote</th>");
		out.print("<th>Action</th>");
		out.print("</tr>");
		out.print("</thead>");
		out.print("<body>");
		
		for(Candidate c : list) {
			out.print("<tr>");
			out.printf("<td>%s</td>\n",c.getId());
			out.printf("<td>%s</td>\n",c.getName());
			out.printf("<td>%s</td>\n",c.getParty());
			out.printf("<td>%s</td>\n",c.getVotes());
			out.printf("<td>");
			out.printf("<a href='edit?id=%d'><img src='images/edit.png' alt='Edit' width='20' height='20'/></a>\n", c.getId());			
			out.printf("<a href='delete?id=%d'><img src='images/delete.png' alt='Delete' width='20' height='20'/></a>\n", c.getId());

			out.print("</td>");
			out.print("</tr>");
		}
		
		out.print("</body>");
		out.print("</table>");
		
		String message = (String) req.getAttribute("msg");
		if(message != null) {
			out.print("<p>"+ message +"</p>");
		}
		out.print("<p><a href='announcement.html'>Post announcement</a></p>");
		out.print("<p><a href='newCandidate.html'>Register New Candidate</a></p>");
		out.print("</body>");
		out.print("</html>");
	}

	
	
}
