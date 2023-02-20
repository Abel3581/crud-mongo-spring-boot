package com.crud.nosql.controller;

import com.crud.nosql.dto.MessageRequest;
import com.crud.nosql.service.abstraction.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/{id}")
    public ResponseEntity<?> addMessageToProduct(@PathVariable String id, @Valid @RequestBody MessageRequest
                                                 request, BindingResult result){
        Map<String, Object> validations = new HashMap<>();
        if(result.hasErrors()){
            result.getFieldErrors()
                    .forEach(fieldError -> {
                        validations.put(fieldError.getField(), fieldError.getDefaultMessage());
                    });
            return ResponseEntity.badRequest().body(validations);
        }
        messageService.save(id, request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mensaje cargado con exito");

    }
}
