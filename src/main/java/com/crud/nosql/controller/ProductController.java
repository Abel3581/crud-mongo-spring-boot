package com.crud.nosql.controller;

import com.crud.nosql.dto.ProductRequest;
import com.crud.nosql.dto.ProductResponse;
import com.crud.nosql.service.ProductServiceImpl;

import com.crud.nosql.service.abstraction.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;
    @PostMapping()
    public ResponseEntity<?> save(@Valid @RequestBody ProductRequest request, BindingResult result){
        Map<String, Object> validations = new HashMap<>();
        if(result.hasErrors()){
            log.info("Ocurrio una validacion");
            result.getFieldErrors()
                    .forEach(error ->{
                        log.info("Campo: " + error.getField() + " validacion: " + error.getDefaultMessage());
                        validations.put(error.getField(), error.getDefaultMessage());
                    });
            return ResponseEntity.badRequest().body(validations);

            }
        productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto cargado con exito");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@PathVariable String id){
        ProductResponse response = productService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
