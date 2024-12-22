package com.java.beans;

import java.util.ArrayList;
import java.util.List;

import com.jdbc.dao.CandidateDao;
import com.jdbc.daoImpl.CandidateDaoImpl;
import com.jdbc.entities.Candidate;

public class ResultBean {
	private List<Candidate> candList;
	public ResultBean() {
		this.candList = new ArrayList<Candidate>();
	}
	public List<Candidate> getCandList() {
		return candList;
	}
	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()) {
			this.candList = candDao.findAllCandidates();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
