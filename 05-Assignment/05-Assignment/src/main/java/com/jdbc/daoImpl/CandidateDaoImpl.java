package com.jdbc.daoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.CandidateDao;
import com.jdbc.dao.Dao;
import com.jdbc.entities.Candidate;
import com.jdbc.entities.User;

public class CandidateDaoImpl extends Dao implements CandidateDao{

	private PreparedStatement psFindAll;
	private PreparedStatement psFindById;
	private PreparedStatement psSaveCandidate;
	private PreparedStatement psUpdateCandidate;
	private PreparedStatement psDeleteCandidate;
	private PreparedStatement showRes;
	private PreparedStatement psUpdateVotes;

	public CandidateDaoImpl() throws Exception {
		super(); // it call the dao class default consturctor and make the connection.

		String sqlFindAll = "SELECT * FROM candidates";
		psFindAll = con.prepareStatement(sqlFindAll);

		String findById = "SELECT * FROM candidates where id=?";
		psFindById = con.prepareStatement(findById);

		String saveCandidate = "insert into candidates (name,party,votes) values(?,?,?)";
		psSaveCandidate = con.prepareStatement(saveCandidate);

		String updateCandidate = "update candidates set name=?,party=?,votes=? where id=?";
		psUpdateCandidate = con.prepareStatement(updateCandidate);
		
		String deleteCandidate = "delete from candidates where id=?";
		psDeleteCandidate = con.prepareStatement(deleteCandidate);
		

		String query = "select * from candidates order by votes desc limit 1";
		showRes = con.prepareStatement(query);
		
		String UpdateVotes = "update candidates set votes=? where id=?";
		psUpdateVotes = con.prepareStatement(UpdateVotes);
		
	}


	@Override
	public void close() throws Exception {
		psUpdateVotes.close();
		showRes.close();
		psDeleteCandidate.close();
		psUpdateCandidate.close();
		psSaveCandidate.close();
		psFindById.close();
		psFindAll.close();
		super.close(); // closing dao class connection.
	}


	@Override
	public List<Candidate> findAllCandidates() throws Exception {
		List<Candidate> candidates = new ArrayList<>();
		try(ResultSet rs = psFindAll.executeQuery()) {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String party = rs.getString("party");
				int votes = rs.getInt("votes");
				Candidate c = new Candidate(id, name, party, votes);
				candidates.add(c);
			}
		} // rs.close();
		return candidates;
	}


	@Override
	public Candidate findCandidateById(int id) throws Exception
	{
		psFindById.setInt(1, id);
		try(ResultSet rs = psFindById.executeQuery()) {
			if(rs.next()) {
				id = rs.getInt("id");
				String name = rs.getString("name");
				String party = rs.getString("party");
				int votes = rs.getInt("votes");
				Candidate candidate = new Candidate(id, name, party, votes);
				return candidate;

			}
		} // rs.close();
		return null;
	}


	@Override
	public int saveCandidate(Candidate c) throws Exception {
		psSaveCandidate.setString(1, c.getName());
		psSaveCandidate.setString(2, c.getParty());
		psSaveCandidate.setInt(3, c.getVotes());
		int res = psSaveCandidate.executeUpdate();
		return res;
	}


	@Override
	public int updateCandidate(Candidate c) throws Exception {
		psUpdateCandidate.setString(1, c.getName());
		psUpdateCandidate.setString(2, c.getParty());
		psUpdateCandidate.setInt(3, c.getVotes());
		psUpdateCandidate.setInt(4, c.getId());
		int res = psUpdateCandidate.executeUpdate();
		return res;
	}
	
	@Override
	public int deleteCandidate(int id) throws Exception {
		psDeleteCandidate.setInt(1, id);
		int res = psDeleteCandidate.executeUpdate();
		return res;
	}
	
	
	@Override
	public Candidate showResult() throws Exception {
		ResultSet rs = showRes.executeQuery();
		if (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String party = rs.getString("party");
			int votes = rs.getInt("votes");
			Candidate candidate = new Candidate(id, name, party, votes);
			return candidate;
		}

		return null;
	}
	
	
	
	@Override
	public int updateCandidateVotes(Candidate c) throws Exception {
		System.out.println(c.getVotes());
		psUpdateVotes.setInt(1, c.getVotes() + 1);
		psUpdateVotes.setInt(2, c.getId());
		int res = psUpdateVotes.executeUpdate();
		return res;
	}
}
