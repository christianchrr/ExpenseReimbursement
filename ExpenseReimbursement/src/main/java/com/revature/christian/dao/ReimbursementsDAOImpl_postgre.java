package com.revature.christian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.christian.connectionutil.ConnectionUtility;
import com.revature.christian.model.Reimbursements;
import com.revature.christian.model.Users;

public class ReimbursementsDAOImpl_postgre implements ReimbursementsDAO {
	
	@Override
	public Reimbursements getReimbursements(Integer id) {
		Reimbursements reimbursement = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.reimbursements WHERE user_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				reimbursement = new Reimbursements(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4), rs.getString(5));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}
	
	@Override
	public Boolean removeReimbursements(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("DELETE FROM expense_reimbursement_project.reimbursements WHERE reimbursement_id=?");
			ps.setInt(1, id);
			int res = ps.executeUpdate();
			if (res == 0) {
				return false;
			} else {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Reimbursements> getAllReimbursements() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<Reimbursements> reimbursements = new ArrayList<Reimbursements>();

		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.reimbursements");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursement_id(rs.getInt(1));
				reimbursement.setUser_id(rs.getInt(2));
				reimbursement.setReason(rs.getString(3));
				reimbursement.setAmount(rs.getDouble(4));
				reimbursement.setStatus(rs.getString(5));

				reimbursements.add(reimbursement);
			}
		} catch(SQLException e) { 
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	@Override
	public List<Reimbursements> getAllReimbursementsById(Integer id) {
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<Reimbursements> reimbursements = new ArrayList<Reimbursements>();

		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.reimbursements WHERE user_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursements reimbursement = new Reimbursements();
				reimbursement.setReimbursement_id(rs.getInt(1));
				reimbursement.setUser_id(rs.getInt(2));
				reimbursement.setReason(rs.getString(3));
				reimbursement.setAmount(rs.getDouble(4));
				reimbursement.setStatus(rs.getString(5));

				reimbursements.add(reimbursement);
			}
		} catch(SQLException e) { 
			e.printStackTrace();
		}
		return reimbursements;
	}

	@Override
	public Boolean insertIntoReimbursements(Reimbursements reimbursement) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO expense_reimbursement_project.reimbursements " + "VALUES(default,?,?,?,?)");
			
			ps.setInt(1, reimbursement.getUser_id());
			ps.setString(2, reimbursement.getReason());
			ps.setDouble(3, reimbursement.getAmount());
			ps.setString(4, reimbursement.getStatus());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	@Override
	public Boolean insertIntoReimbursements(Users user, String reason, Double amount, String status) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO expense_reimbursement_project.reimbursements " + "VALUES(default,?,?,?,?)");
			
			ps.setInt(1, user.getUser_id());
			ps.setString(2, reason);
			ps.setDouble(3, amount);
			ps.setString(4, status);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean updateReimbursements(Users user, Integer id, String reason, Double amount, String status) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("UPDATE expense_reimbursement_project.reimbursements SET user_id=?, reason=?, amount=?, status=? WHERE user_username=?");
			ps.setInt(1, id);
			ps.setString(2, reason);
			ps.setDouble(3, amount);
			ps.setString(4, status);
			ps.setString(5, user.getUser_username());
			int res = ps.executeUpdate();
			if (res == 0) {
				return false;
			} else {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Reimbursements selectReimbursementByUserId(Integer id) {
		Reimbursements reimbursement = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.reimbursements WHERE user_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				reimbursement = new Reimbursements(
						rs.getInt(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getDouble(4), 
						rs.getString(5)
				);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return reimbursement;
	}

//	@Override
//	public Users getUsers(String info) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
