package com.java.beans;import com.jdbc.dao.CandidateDao;
import com.jdbc.daoImpl.CandidateDaoImpl;

public class deleteCandidate 
{
	private int candId;
	private int count;
	
	public deleteCandidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public deleteCandidate(int candId, int count) {
		super();
		this.candId = candId;
		this.count = count;
	}
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public void deleteCand() throws Exception {
		try(CandidateDao cDao = new CandidateDaoImpl())
		{
			this.count=cDao.deleteCandidate(candId);
		}
	}

}
