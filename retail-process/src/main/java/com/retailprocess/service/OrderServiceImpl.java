package com.retailprocess.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retailprocess.enums.ProductType;
import com.retailprocess.model.Affiliate;
import com.retailprocess.model.Customer;
import com.retailprocess.model.Employee;
import com.retailprocess.model.Product;
import com.retailprocess.model.User;
import com.retailprocess.util.ApplicationUtil;




public class OrderServiceImpl implements OrderService {

	private static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	private static final float EMP_DISCOUNT = 0.3f;
	private static final float AFFILIATE_DISCOUNT = 0.1f;
	private static final float CUSTOMER_DISCOUNT = 0.05f;
	private static final int PER_HUNDARD_DISCOUNT = 5;
	private static final int CUSTOMER_DURATION_WITH_CO = 2;
	
	
	@Override
	public float totalBillOrder(User user, List<Product> productList) {
		LOG.info("ProcessOrder User Id :[{}], userType :[{}]", user.getId(), user.getUserType());
		float netBillPayable = calculateTotalPrice(productList) - 
				calculateDiscount(user, productList);
		LOG.info("Net Payable bill : [{}]", netBillPayable);
		return netBillPayable;
	}
	/**
	 * This method calculates the total price of the products
	 * @param productList
	 * @return totalPrice
	 */

	private static float calculateTotalPrice(List<Product> productList) {
		double totalPrice = productList.stream()
				.map(Product::getPrice)
				.mapToDouble(v -> v).sum();
		totalPrice = Math.round(totalPrice*100.0)/100.0;
		LOG.info("Total Price :[{}]", totalPrice);
		return (float)totalPrice;
	}
	
	/**
	 * This method is used for calculating the total discount applicable for the products for the particular user
	 * @param user
	 * @param productList
	 * @return totalDiscount
	 */
	

	private static float calculateDiscount(User user, List<Product> productList) {
		float totalDiscount = 0.0f;
		float totalPrice = 0.0f;
		for(Product product : productList) {
			//calculate the discounts for the products which are not grocery
			if(!product.getType().equalsIgnoreCase(ProductType.GROCERY.name())) {
				if(user instanceof Employee) {
					totalDiscount = totalDiscount + (product.getPrice() * EMP_DISCOUNT);
				} else if(user instanceof Affiliate) {
					totalDiscount = totalDiscount + (product.getPrice() * AFFILIATE_DISCOUNT);
				} else if (user instanceof Customer && 
						(ApplicationUtil.getCustomerDuration(user.getCreationDate()) >= CUSTOMER_DURATION_WITH_CO)) {
					totalDiscount = totalDiscount + (product.getPrice() * CUSTOMER_DISCOUNT);
				}
				
			}
			totalPrice = totalPrice + product.getPrice();
		}
		//calculation of 5$discount for every 100$ on the bill
		int perHundardDiscount = ((int) (totalPrice/100) * PER_HUNDARD_DISCOUNT);
		totalDiscount = totalDiscount + perHundardDiscount;
		LOG.info("Total Discount :[{}]", totalDiscount);
		return totalDiscount;
	}
}
