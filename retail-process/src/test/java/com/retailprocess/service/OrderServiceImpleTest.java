package com.retailprocess.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.retailprocess.model.Product;
import com.retailprocess.model.User;
import com.retailprocess.utility.TestData;



public class OrderServiceImpleTest {

	OrderServiceImpl subject = new OrderServiceImpl();
	
	
	/**
	 * Test case for the user is an employee and buying groceries products so there is no percentage based discounts applicable
	 */
	
	@Test
    public void testProcessGroceryOrderForEmployee() {
       User employee = TestData.getUserAsEmployee();
       List<Product> list = TestData.getGroceryProductList();
       float expected = (float) ((float)(Math.round((115.60f + 150.00f)*100.0)/100.0) - (10.00));
       float result = subject.totalBillOrder(employee, list);
       assertEquals(expected, result,0.001);
    }

	
	/**
	 * Test case for the User is an employee and buying non grocery products
	 */
	@Test
    public void testProcessNonGroceryOrderForEmployee() {
       User employee = TestData.getUserAsEmployee();
       List<Product> list = TestData.getNonGroceryProductList();
       float expected = (float) ((float)(Math.round((115.60f + 150.00f)*100.0)/100.0) - (89.68));
       float result = subject.totalBillOrder(employee, list);
       assertEquals(expected, result,0.001);
    }
	
	/**
	 * Test case for the customer who has been for over 2 years and buying grocery order
	 */
	@Test
    public void testProcessGroceryOrderForCustomer() {
       User customer = TestData.getUserAsCustomer();
       List<Product> list = TestData.getGroceryProductList();
       float expected = (float) ((float)(Math.round((115.60f + 150.00f)*100.0)/100.0) - (10.00));
       float result = subject.totalBillOrder(customer, list);
       assertEquals(expected, result,0.001);
    }
	
	/**
	 * Test case for the customer who has been for over 2 years and buying both products
	 */

	@Test
    public void testProcessOrderBothProductForCustomer() {
       User customer = TestData.getUserAsCustomer();
       List<Product> list = TestData.getAllProductList();
       float expected = (float) ((float)(Math.round((115.60f + 150.00f)*100.0)/100.0) - (17.5));
       float result = subject.totalBillOrder(customer, list);
       assertEquals(expected, result,0.001);
    }
	
	/**
	 * Test case for user is an affiliate for the store and buying grocery items
	 */
	
	@Test
    public void testProcessGroceryOrderForAffiliate() {
       User affiliate = TestData.getUserAsAffiliate();
       List<Product> list = TestData.getGroceryProductList();
       float expected = (float) ((float)(Math.round((115.60f + 150.00f)*100.0)/100.0) - (10.00));
       float result = subject.totalBillOrder(affiliate, list);
       assertEquals(expected, result,0.001);
    }
	
	/**
	 * Test case for the user is an affiliate of the store and buying both the products
	 */

	@Test
    public void testProcessOrderBothProductForAffiliate() {
       User affiliate = TestData.getUserAsAffiliate();
       List<Product> list = TestData.getAllProductList();
       float expected = (float) ((float)(Math.round((115.60f + 150.00f)*100.0)/100.0) - (25.0));
       float result = subject.totalBillOrder(affiliate, list);
       assertEquals(expected, result,0.001);
    }
}


