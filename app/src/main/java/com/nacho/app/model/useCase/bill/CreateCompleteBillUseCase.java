package com.nacho.app.model.useCase.bill;


import com.nacho.app.repository.mapper.BillMapperImpl;
import com.nacho.app.service.bill.BillServiceImpl;
import com.nacho.app.service.person.PersonServiceImpl;
import com.nacho.app.service.product.ProductServiceImpl;
import model.Bill;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateCompleteBillUseCase {

    BillServiceImpl billService;
    BillMapperImpl billMapper;

    ProductServiceImpl productService;
    PersonServiceImpl personService;

    public CreateCompleteBillUseCase(BillServiceImpl billService, BillMapperImpl billMapper,
                                     ProductServiceImpl productService, PersonServiceImpl personService
                                     ){
        this.billService = billService;
        this.billMapper = billMapper;

        this.productService = productService;
        this.personService = personService;
    }

    public Mono<Bill> dispacth(com.nacho.app.model.Bill bill){
       return personService.createPerson(bill.getPerson())
               .then(productService.createProduct(bill.getProductEntity()))
                    .then(billService.createBill(bill)).map(billCreated -> billMapper.billToBillApi(billCreated));
    }
}
