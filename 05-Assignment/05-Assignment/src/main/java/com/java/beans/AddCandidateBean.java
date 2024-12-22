package com.java.beans;

import com.jdbc.dao.CandidateDao;
import com.jdbc.daoImpl.CandidateDaoImpl;
import com.jdbc.entities.Candidate;

public class AddCandidateBean 
{
	private int id;
	private String name;
	private String party;
	private int votes;
	private int count;
	
	
	public AddCandidateBean() {
		super();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void addCand()
	{
		try(CandidateDao cDao = new CandidateDaoImpl()) {
			votes = 30;
			Candidate candidate = new Candidate(0, name, party, votes);
			this.count = cDao.saveCandidate(candidate);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
