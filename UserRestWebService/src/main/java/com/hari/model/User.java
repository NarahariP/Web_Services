package com.hari.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String user;
	private String role;
	private Date dataOfBirth;

	public User() {
	}

	public User(String user, String role, Date dataOfBirth) {
		super();
		this.user = user;
		this.role = role;
		this.dataOfBirth = dataOfBirth;
	}

	public User(Integer id, String user, String role, Date dataOfBirth) {
		super();
		this.id = id;
		this.user = user;
		this.role = role;
		this.dataOfBirth = dataOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", role=" + role + ", dataOfBirth=" + dataOfBirth + "]";
	}

}
