package com.example.orders;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepo extends CrudRepository<CustomerOrder, Integer>{

}
