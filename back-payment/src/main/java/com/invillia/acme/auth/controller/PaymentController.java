package com.invillia.acme.auth.controller;


import com.invillia.acme.auth.db.dto.PaymentDto;
import com.invillia.acme.auth.db.entity.Payment;
import com.invillia.acme.auth.db.enums.PaymentStatusEnum;
import com.invillia.acme.auth.db.mapper.PaymentMapper;
import com.invillia.acme.auth.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;

@RestController()
@RequestMapping(path = "/payments", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "Payment")
public class PaymentController extends BaseController<Payment, PaymentService> {

    /**
     * Método responsável por salvar uma payment
     *
     * @param paymentDto
     * @return ResponseEntity
     */
    @PostMapping("/save")
    @ApiOperation(notes = "Salvar os dados de uma payment", value = "payment", response = ResponseEntity.class)
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<PaymentDto> save(@Validated @RequestBody PaymentDto paymentDto) throws Exception {
        boolean newRegist = false;
        if (Objects.isNull(paymentDto.getId())) {
            paymentDto.setId(UUID.randomUUID().toString().toUpperCase());
            newRegist = true;
        }
        Payment payment = PaymentMapper.convertTo(paymentDto);
        if (newRegist){
            payment.setStatusPayment(PaymentStatusEnum.PROCESSED);
        }
        payment = getService().persistence(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(PaymentMapper.convertFrom(payment));
    }

    /**
     * Metodo responsável por atualizar uma Store
     *
     * @param storeDto
     * @return ResponseEntity
     */
//    @PutMapping("/update/{id}")
//    @ApiOperation(notes = "Atualiar os dados de uma Store", value = "Store", response = ResponseEntity.class)
//    //@Secured("ROLE_ADMIN")
//    public ResponseEntity<StoreDto> update(@Validated @RequestBody StoreDto storeDto, @PathVariable String id)
//            throws Exception {
//        Assert.notNull(id, "Id is not null");
//        Store store = getService().update(StoreMapper.convertTo(storeDto), id);
//        return ResponseEntity.status(HttpStatus.OK).body(StoreMapper.convertFrom(store));
//    }
//
//    /**
//     * Consultar Store por parametros
//     *
//     * @param name
//     * @param address
//     * @return ResponseEntity
//     */
//    @GetMapping("/find")
//    @ApiOperation(notes = "Recuperar uma Store por parametros", value = "Filter", response = ResponseEntity.class)
//    //@Secured("ROLE_ADMIN")
//    public ResponseEntity<List<StoreDto>> getStore(@RequestParam(required = false) String name,
//                                                   @RequestParam(required = false) String address) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(StoreMapper
//                        .convertFrom(getService()
//                        .findStore(name, address)));
//    }

}
