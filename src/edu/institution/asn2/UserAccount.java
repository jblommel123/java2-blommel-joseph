package edu.institution.asn2;

import java.io.Serializable;

public abstract class UserAccount implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 510626820083953723L;
	//implement serializable
	private String username;
	private String password;
	
	public UserAccount(String Username, String Password) {
		username = Username;
		password = Password;
	}
	
	public UserAccount() {
		
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isPasswordCorrect(String passwordToCheck) {
		if (passwordToCheck == null || this.password == null) {
			return false;
		}
		return (this.password.equalsIgnoreCase(passwordToCheck));
	}

	@Override
	public String toString() {
		return username;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		UserAccount other = (UserAccount) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	public abstract void setType(String type);


}
