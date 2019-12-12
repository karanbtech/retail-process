package com.retailprocess.model;

public class Product {

	private long id;
	private String name;
	private String type;
	private float price;

	private Product(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.type = builder.type;
		this.price = builder.price;
	}

	public Product() {	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public float getPrice() {
		return price;
	}

	public static Builder builder() {
		return new Builder();
	}

	
	public static final class Builder {
		private long id;
		private String name;
		private String type;
		private float price;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withType(String type) {
			this.type = type;
			return this;
		}

		public Builder withPrice(float price) {
			this.price = price;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}

	
}
