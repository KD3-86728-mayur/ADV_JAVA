package com.ecom.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.OrderDao;
import com.ecom.dao.ProductDao;
import com.ecom.dao.UserDao;
import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderDto;
import com.ecom.pojos.Orders;
import com.ecom.pojos.Product;
import com.ecom.pojos.User;
import com.ecom.pojos.UserRole;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private ProductDao productDao;

	@Override
	public ApiResponse placeNewOrder(OrderDto dto, int quantity) {

		User user = userDao.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("Invalid User"));
		Product product = productDao.findById(dto.getProductId())
				.orElseThrow(() -> new RuntimeException("Invalid Product Id"));
		Orders order = mapper.map(dto, Orders.class);
		System.out.println(order);
		System.out.println(user);
		System.out.println(product);

		if (user.getRole() == UserRole.CUSTOMER && quantity <= product.getQuantity() && product.getStatus() == 1) {
			System.out.println(order);
//			bill = product.getPrice() * quantity;
			order.setBill(product.getPrice() * quantity);
			order.setUserId(user);
			order.setProductId(product);
			Orders placedOrder = orderDao.save(order);
			System.out.println(placedOrder);

			return new ApiResponse("Order Placed");
		}

		return new ApiResponse("Failed To Place Order");
	}

}
