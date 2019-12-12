package com.retailprocess.model;

import java.util.Date;

public class User {
	
	private long id;
	private String name;
	private String userType;
	private String address;
	private Date creationDate;
	
	protected User(long id, String name, String userType, String address, Date creationDate) {
		this.id = id;
		this.name = name;
		this.userType = userType;
		this.address = address;
		this.creationDate = creationDate;
	}
	protected User(){}
	
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUserType() {
		return userType;
	}
	public String getAddress() {
		return address;
	}
	
}
