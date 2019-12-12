package com.retailprocess.model;

import java.util.Date;

public class Customer extends User {
	
	public Customer() {
	}

	public Customer(Builder builder) {
		super(builder.id, builder.name, builder.userType, builder.address,builder.creationDate);
	}

	public static Builder builder() {
		return new Builder();
	}


	public static final class Builder {
		private Date creationDate;
		private String address;
		private String userType;
		private String name;
		private long id;

		private Builder() {
		}

		public Builder withCreationDate(Date creationDate) {
			this.creationDate = creationDate;
			return this;
		}

		public Builder withAddress(String address) {
			this.address = address;
			return this;
		}

		public Builder withUserType(String userType) {
			this.userType = userType;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}


}
