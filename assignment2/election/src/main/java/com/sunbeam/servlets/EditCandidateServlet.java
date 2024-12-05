package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/edit")
public class EditCandidateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String temp = req.getParameter("id");
		int id = Integer.parseInt(temp);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title> Election Application</title>");
		out.print("</head>");
		ServletContext app1 = this.getServletContext();
		String appbg= app1.getInitParameter("app1.bg");
		out.printf("<body bgcolor='%s'>",appbg);
		
		try(CandidateDao cdao = new CandidateDaoImpl()) {
			Candidate c = cdao.findById(id);
			if(c != null) {
				out.print("<form method='post' action='edit'>");
				out.printf("<input type='hidden' name='id' value='%d' readonly/><br/>",c.getId());
				out.printf("Name: <input type='text' name='name' value='%s'/><br/>",c.getName());
				out.printf("Party: <input type='text' name='party' value='%s'/><br/>",c.getParty());
				out.printf("Votes: <input type='text' name='votes' value='%d' readonly/><br/>",c.getVotes());
				out.print("<input type='submit' value='Update'>");
				out.print("</form>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("</body>");
		out.print("</html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String party = req.getParameter("party");
		String votes = req.getParameter("votes");
		Candidate c = new Candidate(id, name, party, id);
		try(CandidateDao cdao = new CandidateDaoImpl()) {
			int count = cdao.update(c);
			String messgae = "Update Status : " + count;
			req.setAttribute("msg", messgae);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher r = req.getRequestDispatcher("result");
		r.forward(req, resp);
		
	}
	
	

	
}
