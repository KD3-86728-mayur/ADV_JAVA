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


@WebServlet("/candlist")
public class CandidateListServlet extends HttpServlet{

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
		out.print("<title> Election Application</title>");
		out.print("</head>");
		
		ServletContext app1 = this.getServletContext();
		String appbg= app1.getInitParameter("app1.bg");
		out.printf("<body bgcolor='%s'>",appbg);
		
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		Cookie[] arr = req.getCookies();
		String un = "";
		String rl = "";
		if(arr != null) {
		for(Cookie c : arr) {
			if(c.getName().equals("uname")) {
				un = c.getValue();
			}
			
			if(c.getName().equals("role")) {
				rl =  c.getValue();
			}
			
		}
		}
		out.printf("<h3>Hello, %s [%s]</h3>",un,rl);
		
		ServletContext ctx2 = req.getServletContext();
		String annou = (String) ctx2.getAttribute("annous");
		if(annou != null) {
			out.print("<p>"+annou+"</p>");
		}
		
		out.print("Candidate List:-");
		out.print("<form method='post' action='vote'>");
		for(Candidate c : list) {
			out.printf("<input type='radio' name='candidate' value='%d' /> %s\n",c.getId(),c.getName());
		}
		out.println("<br/><input type='submit' value='Vote'/>");
		out.print("<form>");
		out.print("</body>");
		out.print("</html>");
	}

	
	
}
