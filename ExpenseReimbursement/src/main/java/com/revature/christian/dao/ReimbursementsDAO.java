package com.revature.christian.dao;

import java.util.List;

import com.revature.christian.model.Reimbursements;

public interface ReimbursementsDAO {
	
	public Reimbursements getReimbursements(Integer id);
//	public Reimbursements getReinbursements(String info);
	public List<Reimbursements> getAllReimbursements();
	public Boolean insertIntoReimbursements(Reimbursements reimbursement);
	public Boolean removeReimbursements(Integer id);
	public Boolean updateReimbursements(Reimbursements reimbursement);

}
