package com.hari.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "All User Fileds Are Manditory!")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Size(min = 3, message = "User name should have at least 3 characters!")
	@ApiModelProperty(notes = "User name should have at least 3 characters!")
	private String user;
	@Size(min = 3, message = "User role must contains at leas 3 characters!")
	@ApiModelProperty(notes = "User role should have at least 3 characters!")
	private String role;
	@Past(message = "Date of Birth can't be a feature date!")
	@ApiModelProperty(notes = "Date of Birth can't be a feature date!")
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
