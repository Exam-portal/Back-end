package com.onlineexam.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Users")
public class UserTable {

	@Id
	@GeneratedValue
	private int id;
	
	@NotNull
	private String name;
	
	private String role;
	
	@NotNull
	private String address;

	@NotNull
	@Email(message="Email should be valid")
	private String email;
	
	@NotNull
	private String password;
	
//	@NotNull
	private String code="";
	
	@NotNull
	private String status="N";

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserTable [id=" + id + ", name=" + name + ", role=" + role + ", address=" + address + ", email=" + email
				+ ", password=" + password + ", code=" + code + ", status=" + status + "]";
	}




}
