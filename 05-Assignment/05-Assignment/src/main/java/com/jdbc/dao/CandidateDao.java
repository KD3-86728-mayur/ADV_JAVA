package com.jdbc.dao;

import java.util.List;

import com.jdbc.entities.Candidate;
import com.jdbc.entities.User;

public interface CandidateDao extends AutoCloseable
{
	public List<Candidate> findAllCandidates() throws Exception;

	public Candidate findCandidateById(int id) throws Exception;

	int saveCandidate(Candidate c) throws Exception;

	int updateCandidate(Candidate c) throws Exception;
	int deleteCandidate(int id) throws Exception;
	
	
	// for ElectionApplication
	Candidate showResult() throws Exception;
	int updateCandidateVotes(Candidate c) throws Exception;

}
