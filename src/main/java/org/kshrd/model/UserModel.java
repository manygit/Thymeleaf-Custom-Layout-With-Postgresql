package org.kshrd.model;

public class UserModel {
	private int id;
	private String name;
	private String gender;
	private String email;
	private String phone;
	private boolean status; 
	private String userHash;
	private RoleModel role;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUserHash() {
		return userHash;
	}

	public void setUserHash(String userHash) {
		this.userHash = userHash;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	public UserModel(int id, String name, String gender, String email, String phone, boolean status, String userHash,
			RoleModel role) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.status = status;
		this.userHash = userHash;
		this.role = role;
	}
	public UserModel() {}
}
