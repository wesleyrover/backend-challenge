package com.invillia.acme.order.controller;

import com.invillia.acme.order.db.dto.OrderDto;
import com.invillia.acme.order.db.entity.Order;
import com.invillia.acme.order.db.mapper.OrderMapper;
import com.invillia.acme.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController()
@RequestMapping(path = "/orders", produces = {MediaType.APPLICATION_JSON_VALUE})
@Api(value = "Order")
public class OrderController extends BaseController<Order, OrderService> {

    /**
     * Método responsável por salvar uma Order
     *
     * @param orderDto
     * @return ResponseEntity
     */
    @PostMapping("/save")
    @ApiOperation(notes = "Salvar os dados de uma Order", value = "Order", response = ResponseEntity.class)
    @Secured("ROLE_USER")
    public ResponseEntity<OrderDto> save(@Validated @RequestBody OrderDto orderDto) throws Exception {
        if (Objects.isNull(orderDto.getId()))
            orderDto.setId(UUID.randomUUID().toString().toUpperCase());
        if (Objects.nonNull(orderDto.getItems()) && !orderDto.getItems().isEmpty())
            orderDto.getItems().forEach(
                    orderItemDTO -> {
                        if (Objects.isNull(orderItemDTO.getId()))
                            orderItemDTO.setId(UUID.randomUUID().toString().toUpperCase());
                    }
            );

        Order store = getService().persistence(OrderMapper.convertTo(orderDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(OrderMapper.convertFrom(store));
    }

    /**
     * Metodo responsável por atualizar uma Store
     *
     * @param storeDto
     * @return ResponseEntity
     */
    @PutMapping("/update/{id}")
    @ApiOperation(notes = "Atualiar os dados de uma Store", value = "Store", response = ResponseEntity.class)
    @Secured("ROLE_USER")
    public ResponseEntity<OrderDto> update(@Validated @RequestBody OrderDto storeDto, @PathVariable String id)
            throws Exception {
        Assert.notNull(id, "Id is not null");
        Order store = getService().update(OrderMapper.convertTo(storeDto), id);
        return ResponseEntity.status(HttpStatus.OK).body(OrderMapper.convertFrom(store));
    }

    /**
     * Consultar Order por parametros
     *
     * @param order
     * @return ResponseEntity
     */
    @GetMapping("/find")
    @ApiOperation(notes = "Recuperar uma order por parametros", value = "Filter", response = ResponseEntity.class)
    @Secured("ROLE_USER")
    public ResponseEntity<List<OrderDto>> getOrder(@RequestParam(required = false) String order) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(OrderMapper
                        .convertFrom(getService()
                        .findOrder(order)));
    }


    /**
     * Metodo responsável por atualizar uma Store
     *
     * @param id
     * @return ResponseEntity
     */
    @PutMapping("/update/{id}")
    @ApiOperation(notes = "Atualiar os dados de uma Store", value = "Store", response = ResponseEntity.class)
    @Secured("ROLE_USER")
    public ResponseEntity<OrderDto> refund(@Validated @PathVariable String id)
            throws Exception {
        Assert.notNull(id, "Id is not null");
        Order order = Order.builder().build();
        order.setId(id);
        Order store = getService().refund(order);
        return ResponseEntity.status(HttpStatus.OK).body(OrderMapper.convertFrom(store));
    }
}
