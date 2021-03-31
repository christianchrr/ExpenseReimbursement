package com.revature.christian.model;

public class Users {
	
	private Integer user_id;
	private String user_first;
	private String user_last;
	private String user_username;
	private String user_password;
	private String user_type;
	
	public Users() {
		super();
	}
	
	public Users(Integer user_id, String user_first, String user_last, String user_username, String user_password, String user_type) {
		super();
		this.setUser_id(user_id);
		this.setUser_first(user_first);
		this.setUser_last(user_last);
		this.setUser_username(user_username);
		this.setUser_password(user_password);
		this.setUser_type(user_type);
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_first() {
		return user_first;
	}

	public void setUser_first(String user_first) {
		this.user_first = user_first;
	}

	public String getUser_last() {
		return user_last;
	}

	public void setUser_last(String user_last) {
		this.user_last = user_last;
	}

	public String getUser_username() {
		return user_username;
	}

	public void setUser_username(String user_username) {
		this.user_username = user_username;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_first == null) ? 0 : user_first.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_last == null) ? 0 : user_last.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + ((user_type == null) ? 0 : user_type.hashCode());
		result = prime * result + ((user_username == null) ? 0 : user_username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		if (user_first == null) {
			if (other.user_first != null)
				return false;
		} else if (!user_first.equals(other.user_first))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_last == null) {
			if (other.user_last != null)
				return false;
		} else if (!user_last.equals(other.user_last))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_type == null) {
			if (other.user_type != null)
				return false;
		} else if (!user_type.equals(other.user_type))
			return false;
		if (user_username == null) {
			if (other.user_username != null)
				return false;
		} else if (!user_username.equals(other.user_username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", user_first=" + user_first + ", user_last=" + user_last
				+ ", user_username=" + user_username + ", user_password=" + user_password + ", user_type=" + user_type
				+ "]";
	}

}
