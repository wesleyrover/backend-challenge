package com.invillia.acme.controller;

import com.invillia.acme.db.dto.StoreDto;
import com.invillia.acme.db.entity.Store;
import com.invillia.acme.db.mapper.StoreMapper;
import com.invillia.acme.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController()
@RequestMapping(path = "/stores", produces = {MediaType.APPLICATION_JSON_VALUE})
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
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<StoreDto> save(@Validated @RequestBody StoreDto storeDto) throws Exception {
        Store store = getService().save(StoreMapper.convertTo(storeDto));
        return ResponseEntity.status(HttpStatus.OK).body(StoreMapper.convertFrom(store));
    }

    /**
     * Metodo responsável por atualizar uma Store
     *
     * @param storeDto
     * @return ResponseEntity
     */
    @PutMapping("/update/{id}")
    @ApiOperation(notes = "Atualiar os dados de uma Store", value = "Store", response = ResponseEntity.class)
    //@Secured("ROLE_ADMIN")
    public ResponseEntity<StoreDto> update(@Validated @RequestBody StoreDto storeDto, @PathVariable Long id)
            throws URISyntaxException {
        Assert.notNull(id, "Id is not null");
        Store store = getService().update(StoreMapper.convertTo(storeDto));
        return ResponseEntity.status(HttpStatus.OK).body(StoreMapper.convertFrom(store));
    }

}
