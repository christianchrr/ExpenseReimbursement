package com.revature.christian.dao;

import java.util.List;

import com.revature.christian.model.Reimbursements;
import com.revature.christian.model.Users;

public interface ReimbursementsDAO {
	
	public Reimbursements getReimbursements(Integer id);
//	public Reimbursements getReinbursements(String info);
	public List<Reimbursements> getAllReimbursements();
	public Boolean insertIntoReimbursements(Reimbursements reimbursement);
	public Boolean removeReimbursements(Integer id);
//	public Boolean updateReimbursements(Reimbursements reimbursement);
	Boolean updateReimbursements(Users user, Integer id, String reason, Double amount, String status);
	Boolean insertIntoReimbursements(Users user, String reason, Double amount, String status);
	List<Reimbursements> getAllReimbursementsById(Integer id);

}
