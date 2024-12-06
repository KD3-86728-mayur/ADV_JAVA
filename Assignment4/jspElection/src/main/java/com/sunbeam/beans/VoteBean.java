package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;

public class VoteBean {

	int candId;
	boolean success;
	int userId;
	public int getCandId() {
		return candId;
	}
	public void setCandId(int candId) {
		this.candId = candId;
	}
	public boolean isSuccess() {
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
	public VoteBean() {
	}
	
	public void vote() {
		
		try (CandidateDao cdao = new CandidateDaoImpl()){
			int count = cdao.incrVote(candId);
			if(count == 1) {
				try(UserDao udao = new UserDaoImpl()) {
					User u = udao.findById(userId);
					if(u != null) {
						u.setStatus(1);
						count = udao.update(u);
						if(count == 1) {
							this.success = true;
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
