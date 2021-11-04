package com.nacho.app.model.useCase.bill;


import com.nacho.app.repository.mapper.BillMapperImpl;
import com.nacho.app.service.bill.BillServiceImpl;
import model.Bill;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class GetBillUseCase {

    BillServiceImpl billService;
    BillMapperImpl billMapper;

    public GetBillUseCase(BillServiceImpl billService, BillMapperImpl billMapper){
        this.billService = billService;
        this.billMapper = billMapper;
    }

    public Mono<List<Bill>> dispacth(){
        return billService.getBills().map(bill ->
                    billMapper.billToBillApi(bill)
                ).collectList();
    }
}
