package com.retailprocess.service;

import java.util.List;

import com.retailprocess.model.Product;
import com.retailprocess.model.User;

public interface OrderService {
	
	public float totalBillOrder(User user, List<Product> productList);
	
}
