package com.nacho.app.service.bill;


import com.nacho.app.model.Bill;
import com.nacho.app.repository.BillRepository;
import com.nacho.app.repository.mapper.BillMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class BillServiceImpl implements BillService {

    BillRepository billRepository;
    BillMapperImpl billMapper;

    @Autowired
    BillServiceImpl(BillRepository billRepository, BillMapperImpl billMapper) {
        this.billRepository = billRepository;
        this.billMapper = billMapper;
    }

    @Override
    public Mono<Bill> createBill(Bill bill) {
        return billRepository.save(bill);
    }

    @Override
    public Mono<Bill> updateBill(Bill bill) {
        return null;
    }

    @Override
    public Mono<Void> deleteBill(Bill bill) {
        return null;
    }

    @Override
    public Flux<Bill> getBills() {
        return billRepository.findAll();
    }
}


