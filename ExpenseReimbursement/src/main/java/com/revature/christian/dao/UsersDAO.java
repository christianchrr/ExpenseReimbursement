package com.revature.christian.dao;

import java.util.List;

import com.revature.christian.model.Users;

public interface UsersDAO {
	
	public Users getUsers(Integer id);
	public Users getUsers(String userName);
	public List<Users> getAllUsers();
	public Boolean insertIntoUsers(Users user);
	public Boolean removeUsers(Integer id);
//	public Boolean updateUsers(Users user);
	public Users selectUsersLogin(String user_username, String user_password);
//	Boolean updateUsers(String first, String last, String username, String password);
	Boolean updateUsers(Users user, String first, String last, String username, String password);

}
