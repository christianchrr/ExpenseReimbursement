package com.revature.christian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.christian.connectionutil.ConnectionUtility;
import com.revature.christian.model.Users;

public class UsersDAOImpl_postgre implements UsersDAO {
	
	@Override
	public Users getUsers(Integer id) {
		Users user = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.users WHERE user_id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	@Override
	public Users selectUsersLogin(String user_username, String user_password) {
		Users user = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.users WHERE user_username=? AND user_password=?");
			ps.setString(1, user_username);
			ps.setString(2, user_password);
			rs = ps.executeQuery();
			while (rs.next()) {
				user = new Users(
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3),	
					rs.getString(4),
					rs.getString(5),
					rs.getString(6)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return user;
	}
	
	@Override
	public Boolean removeUsers(Integer id) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("DELETE FROM expense_reimbursement_project.users WHERE user_id=?");
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
	public List<Users> getAllUsers() {
		ResultSet rs = null;
		PreparedStatement ps = null;
		ArrayList<Users> users = new ArrayList<Users>();

		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.users");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Users user = new Users();
				user.setUser_id(rs.getInt(1));
				user.setUser_first(rs.getString(2));
				user.setUser_last(rs.getString(3));
				user.setUser_username(rs.getString(4));
				user.setUser_password(rs.getString(5));
				user.setUser_type(rs.getString(6));

				users.add(user);
			}
		} catch(SQLException e) { 
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public Boolean insertIntoUsers(Users user) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("INSERT INTO expense_reimbursement_project.users" + "VALUES(default,?,?,?,?,?)");
			
			ps.setString(1, user.getUser_first());
			ps.setString(2, user.getUser_last());
			ps.setString(3, user.getUser_username());
			ps.setString(4, user.getUser_password());
			ps.setString(5, user.getUser_type());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean updateUsers(Users user, String first, String last, String username, String password) {
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("UPDATE expense_reimbursement_project.users SET user_first=?, user_last=?, user_username=?, user_password=? WHERE user_username=?");
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, username);
			ps.setString(4, password);
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
	

	@Override
	public Users getUsers(String userName) {
		Users user = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try (Connection conn = ConnectionUtility.getConnection()) {
			ps = conn.prepareStatement("SELECT * FROM expense_reimbursement_project.users WHERE user_username=?");
			ps.setString(1, userName);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				user = new Users(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6)
				);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

}