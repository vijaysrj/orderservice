package com.example.orders;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {

	@Autowired
	private OrdersService service;

	@PostMapping("/order")
	public Map<String,Object> createOrder(@RequestBody Map<String,Object> order) {

		return this.service.createOrder(order);

	}
}
