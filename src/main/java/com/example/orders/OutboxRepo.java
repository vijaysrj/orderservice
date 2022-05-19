package com.example.orders;

import org.springframework.data.repository.CrudRepository;

public interface OutboxRepo extends CrudRepository<Outbox, Integer>{

}
