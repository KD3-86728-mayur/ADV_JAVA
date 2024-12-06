package com.sunbeam.beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class ResultBean {
	
	List<Candidate> candidates;

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public ResultBean() {
		this.candidates = new ArrayList<Candidate>();
	}
	
	
	public void getCandList() {
		
		try (CandidateDao cdao = new CandidateDaoImpl()){
			this.candidates =  cdao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
