package com.nacho.app.service.bill;

import com.nacho.app.model.Bill;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BillService {
    //CRUD
    Mono<Bill> createBill(Bill bill);
    //Flux<Bill> createCompleteBill(Bill bill);
    Mono<Bill> updateBill(Bill bill);
    Mono<Void> deleteBill(Bill bill);
    Flux<Bill> getBills();
}
