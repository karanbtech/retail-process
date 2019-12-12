package com.retailprocess.model;

import java.util.Date;

public class Employee extends User {
	
	private long managerId;

	private Employee(Builder builder) {
		super(builder.id,builder.name,builder.userType,builder.address,builder.creationDate);
		this.managerId = builder.managerId;
	}
	
	public Employee() {
		super();
	}
		
	public long managerId() {
		return managerId;
	}

	public static Builder builder() {
		return new Builder();
	}
	
	public static final class Builder {
		@SuppressWarnings("unused")
		private long id;
		@SuppressWarnings("unused")
		private String name;
		@SuppressWarnings("unused")
		private String userType;
		
		@SuppressWarnings("unused")
		private String address;
		
		@SuppressWarnings("unused")
		private Date creationDate;
		
		private long managerId;

		private Builder() {
		}

		public Builder withCreationDate(Date creationDate) {
			this.creationDate = creationDate;
			return this;
		}
		
		public Builder withId(long id) {
			this.id = id;
			return this;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withUserType(String userType) {
			this.userType = userType;
			return this;
		}

		public Builder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		public Builder withManagerId(long managerId) {
			this.managerId = managerId;
			return this;
		}

		public Employee build() {
			return new Employee(this);
		}
	}
	
}
