package com.example.orders;

import java.time.LocalDateTime;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepo repo;

	@Autowired
	private OutboxRepo outboxRepo;

	
	@Transactional
	public Map<String,Object> createOrder(Map<String,Object> orderMap) {

		
		CustomerOrder order = new CustomerOrder();
		order.setName(orderMap.get("name").toString());
		order.setQuantity(Integer.parseInt(String.valueOf(orderMap.get("quantity"))));
		this.repo.save(order);

		Outbox outbox = new Outbox();

		outbox.setEvent("order_created");
		outbox.setEventId(order.getId());

		outbox.setPayload(orderMap);

		outbox.setCreatedAt(LocalDateTime.now());

		System.out.println(outbox);
		this.outboxRepo.save(outbox);
		
		
		//delete immediately - still the entry will be picked up from the logs as there was an insert
		//in the previous line
		
		this.outboxRepo.delete(outbox);
		
		
		return Map.of("orderId",order.getId());

	}
}
