package com.crud.nosql.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MessageRequest {

    @Size(max = 200, message = "El mensaje es muy largo")
    @NotBlank(message = "El mensaje no puede estar vacio o ser nulo")
    private String message;
}
