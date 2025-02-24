package ccoem_admin1.models;

public class User {


	private String fname;
	private String lname;
	private String email;
	private String phone;
	private String password;
	private String role;

	// Getters and Setters
	public String getFname() { 
		return fname;
	}
	public void setFname(String fname) { 
		this.fname = fname; 
	}

	public String getLname() {
		return lname;
	}
	public void setLname(String lname) { 
		this.lname = lname;
	}

	public String getEmail() { 
		return email;
	}
	public void setEmail(String email) { 
		this.email = email;
	}

	public String getPhone() { 
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() { 
		return password;
	}
	public void setPassword(String password) { 
		this.password = password;
	}

	public String getRole() { 
		return role;
	}
	public void setRole(String role) { 
		this.role = role;
	}
}


