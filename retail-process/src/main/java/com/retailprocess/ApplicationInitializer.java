package com.retailprocess;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.retailprocess.enums.ProductType;
import com.retailprocess.enums.UserType;
import com.retailprocess.model.Affiliate;
import com.retailprocess.model.Product;
import com.retailprocess.model.User;
import com.retailprocess.service.OrderService;
import com.retailprocess.service.OrderServiceImpl;
import com.retailprocess.util.ApplicationUtil;

public class ApplicationInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationInitializer.class);
	
	public static void main(String[] args) {
		LOG.info("........... Application started ...........");
		ApplicationInitializer obj = new ApplicationInitializer();
		List<Product> list = obj.getPurchasedProductList();
		User user = obj.getUser();
		OrderService orderService = new OrderServiceImpl();
		orderService.totalBillOrder(user, list);
		
	}
	
	private  User getUser() {
		LOG.info("getting dummy user ...........");
		User user = Affiliate.builder()
				.withId(ApplicationUtil.getUniqueId())
				.withAddress("New Delhi")
				.withCreationDate(new Date())
				.withName("Aabid Husain")
				.withUserType(UserType.Affiliate.name())
				.build();
		return user;
	}

	private List<Product> getPurchasedProductList(){
		LOG.info("getting dummy product list ...........");
		Product product = Product.builder()
				.withId(ApplicationUtil.getUniqueId())
				.withName("Rice")
				.withType(ProductType.GROCERY.name())
				.withPrice(115.60f)
				.build();
		List<Product> list = new ArrayList<>();
		list.add(product);
		product = Product.builder()
				.withId(ApplicationUtil.getUniqueId())
				.withName("Paracetamol")
				.withType(ProductType.MEDICINE.name())
				.withPrice(150.00f)
				.build();
		list.add(product);
		return list;
	}
}
