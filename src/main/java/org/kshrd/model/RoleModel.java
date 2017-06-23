package org.kshrd.model;

public class RoleModel {
	private int id;
	private String roleName;
	private String description;
	private String role_hash;
	
	public String getRole_hash() {
		return role_hash;
	}
	public void setRole_hash(String role_hash) {
		this.role_hash = role_hash;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RoleModel(int id, String roleName, String description,String role_hash) {
		this.id = id;
		this.roleName = roleName;
		this.description = description;
		this.role_hash = role_hash;
	}
	
	public RoleModel(){}
}
