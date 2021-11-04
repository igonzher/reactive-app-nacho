package com.nacho.app.controller;

import api.BillApi;
import com.nacho.app.model.useCase.bill.*;
import com.nacho.app.repository.mapper.BillMapperImpl;
import com.nacho.app.service.bill.BillServiceImpl;
import model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BillController implements BillApi {

    private final BillServiceImpl billService;
    BillMapperImpl billMapper;

    GetBillUseCase getBillUseCase;
    CreateBillUseCase createBillUseCase;
    CreateCompleteBillUseCase createCompleteBillUseCase;
    UpdateBillUseCase updateBillUseCase;
    DeleteBillUseCase deleteBillUseCase;

    @Autowired
    public BillController(
            BillServiceImpl billService, BillMapperImpl billMapper,
            GetBillUseCase getBillUseCase, CreateBillUseCase createBillUseCase,
            UpdateBillUseCase updateBillUseCase, DeleteBillUseCase deleteBillUseCase,
            CreateCompleteBillUseCase createCompleteBillUseCase
    ) {
        this.billService = billService;
        this.billMapper = billMapper;

        this.getBillUseCase = getBillUseCase;
        this.createBillUseCase = createBillUseCase;
        this.createCompleteBillUseCase = createCompleteBillUseCase;
        this.updateBillUseCase = updateBillUseCase;
        this.deleteBillUseCase = deleteBillUseCase;
    }

    @Override
    public ResponseEntity<List<Bill>> getBills() {
        List<Bill> responseEntity = getBillUseCase.dispacth().block();
        return new ResponseEntity<>(responseEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Bill> createBill(@RequestBody Bill bill){
        com.nacho.app.model.Bill billToCreate = billMapper.billApiToBill(bill);
        Bill billCreated = createBillUseCase.dispacth(billToCreate).block();
        return new ResponseEntity<>(billCreated, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Bill> createCompleteBill(@RequestBody Bill bill){
        com.nacho.app.model.Bill billToCreate = billMapper.billApiToBill(bill);
        Bill billCreated = createCompleteBillUseCase.dispacth(billToCreate).block();
        return new ResponseEntity<>(billCreated, HttpStatus.CREATED);
    }
}
