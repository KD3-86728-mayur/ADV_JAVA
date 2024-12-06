package com.sunbeam.beans;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;

public class DeleteCandBean {
	int id;
	int count;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public DeleteCandBean() {
	}
	
	public void deleteCand() {
		try (CandidateDao cdao = new CandidateDaoImpl()){
			this.count =  cdao.deleteById(id);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
