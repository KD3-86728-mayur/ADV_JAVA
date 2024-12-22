package com.java.beans;

import com.jdbc.dao.CandidateDao;
import com.jdbc.dao.UserDao;
import com.jdbc.daoImpl.CandidateDaoImpl;
import com.jdbc.daoImpl.UserDaoImpl;
import com.jdbc.entities.Candidate;
import com.jdbc.entities.User;

public class VoteBean {
	private int candId;
	private boolean success;
	private int userId;

	public VoteBean() {
	}

	public int getCandId() {
		return candId;
	}

	public void setCandId(int candId) {
		this.candId = candId;
	}

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void doVote() {
		System.out.println(userId);
		success = false;
		try (UserDao uDao = new UserDaoImpl()) {
			User user = uDao.findUserById(userId);
			if (user.getStatus() == 0) {
				try (CandidateDao cDao = new CandidateDaoImpl()) {
					Candidate can = cDao.findCandidateById(candId);
					int count = cDao.updateCandidateVotes(can);
					int anotherCount = uDao.giveVote(userId);
					if (count == 1 && anotherCount == 1)
						success = true;

				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
