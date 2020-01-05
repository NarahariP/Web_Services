package com.hari.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private int id;
	private String userName;
	private String deptNo;
	@JsonIgnore
	private Date dateOfBirth;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public User(int id, String userName, String deptNo, Date dateOfBirth) {
		super();
		this.id = id;
		this.userName = userName;
		this.deptNo = deptNo;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", deptNo=" + deptNo + ", dateOfBirth=" + dateOfBirth
				+ "]";
	}

	public User() {
		super();
	}

}
