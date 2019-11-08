package com.invillia.acme.controller;

import com.invillia.acme.db.dto.StoreDto;
import com.invillia.acme.db.entity.Store;
import com.invillia.acme.db.mapper.StoreMapper;
import com.invillia.acme.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(path = "/stores", produces = { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "Store")
public class StoreController extends BaseController<Store, StoreService> {

    /**
     * Método responsável por salvar uma Store
     *
     * @param storeDto
     * @return ResponseEntity
     */
    @PostMapping("/save")
    @ApiOperation(notes = "Salvar os dados de uma Store", value = "Store", response = ResponseEntity.class)
    public ResponseEntity<StoreDto> save(@Validated @RequestBody StoreDto storeDto) throws Exception {
        Store store = getService().save(StoreMapper.convertTo(storeDto));
        return ResponseEntity.status(HttpStatus.OK).body(StoreMapper.convertFrom(store)) ;
    }
}
