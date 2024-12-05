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

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet{

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
		String temp = req.getParameter("candidate");
		int id = Integer.parseInt(temp);
		
		resp.setContentType("text.html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>Election</title>");
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
		out.print("<h1>Voting result</h1>");
		

		
//		HttpSession session = req.getSession();
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.sendError(419);
			return;
		}

		User user = (User) session.getAttribute("curUser");
		if(user.getStatus() == 0) {
			try (CandidateDao cdao = new CandidateDaoImpl()){
				int ans = cdao.incrVote(id);
				if(ans == 1) {
					out.print("<p>You have successfully cast the vote</p>");
					user.setStatus(1);
					try(UserDao udao = new UserDaoImpl()){
						int count = udao.update(user);
						if(count == 1) {
							out.print("<p>You are marked as vote!</p>");
						}
					}
				}else {
					out.print("<p>Your voting is failed</p>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			out.print("<p>Already cast vote !</p>");
		}
		
		out.print("<p><a href='logout'>Sign out</a></p>");
		
		out.print("</body>");
		out.print("</html>");
	}
	
	
	

}
