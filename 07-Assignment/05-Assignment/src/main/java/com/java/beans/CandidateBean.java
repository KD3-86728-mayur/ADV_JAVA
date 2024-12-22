package com.java.beans;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.CandidateDao;
import com.jdbc.daoImpl.CandidateDaoImpl;
import com.jdbc.entities.Candidate;

public class CandidateBean 
{
	private List<Candidate> candidates;

	public CandidateBean() {
		candidates = new ArrayList<Candidate>();
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}
	
	
	public void getAllCandidate() {
		try(CandidateDao cDao = new CandidateDaoImpl())
		{
			candidates = cDao.findAllCandidates();
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
