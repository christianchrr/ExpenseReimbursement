package com.revature.christian.connectionutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

import com.revature.christian.dao.UsersDAO;
import com.revature.christian.dao.UsersDAOImpl_postgre;

public class ConnectionUtility {
	
	public static Connection getConnection() throws SQLException {
		
		Driver PostgresDriver = new Driver();
		DriverManager.registerDriver(PostgresDriver);

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pass = "Greenlakeeast28$";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public static void main(String[] args) {
		try (Connection conn = ConnectionUtility.getConnection()) {
			System.out.println("Successful");
		} catch(SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		}
	}

	public static UsersDAO getUserInfoDAO() {
		return new UsersDAOImpl_postgre();
	}

}
