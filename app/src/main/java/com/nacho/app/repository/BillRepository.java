package com.nacho.app.repository;

import com.nacho.app.model.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BillRepository extends ReactiveMongoRepository<Bill, Long> {

}
