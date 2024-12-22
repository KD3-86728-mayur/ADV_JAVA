package com.ecom.service;

import com.ecom.dto.ApiResponse;
import com.ecom.dto.OrderDto;

public interface OrderService {

	ApiResponse placeNewOrder(OrderDto orderDto, int quantity);

}
