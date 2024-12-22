package com.java.beans;

import com.jdbc.dao.CandidateDao;
import com.jdbc.daoImpl.CandidateDaoImpl;
import com.jdbc.entities.Candidate;

public class FindCandidateBean 
{
	private int candId;
	private Candidate cand;
	public FindCandidateBean() {
		
	}
	
	public Candidate getCand() {
		return cand;
	}

	public void setCand(Candidate cand) {
		this.cand = cand;
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public void findCandidate() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			this.cand = candDao.findCandidateById(candId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
