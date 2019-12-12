package com.retailprocess.model;

import java.util.List;
import java.util.Collections;

public class Order {

	private long id;
	private List<Product> productList;
	private float totalPrice;

	private Order(Builder builder) {
		this.id = builder.id;
		this.productList = builder.productList;
		this.totalPrice = builder.totalPrice;
	}
	
	public Order() { }

	public Order(long id, List<Product> productList, float totalPrice) {
		this.id = id;
		this.productList = productList;
		this.totalPrice = totalPrice;
	}

	public long getId() {
		return id;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private long id;
		private List<Product> productList = Collections.emptyList();
		private float totalPrice;

		private Builder() {
		}

		public Builder withId(long id) {
			this.id = id;
			return this;
		}

		public Builder withProductList(List<Product> productList) {
			this.productList = productList;
			return this;
		}

		public Builder withTotalPrice(float totalPrice) {
			this.totalPrice = totalPrice;
			return this;
		}

		public Order build() {
			return new Order(this);
		}
	}
	
}
