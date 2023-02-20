package com.crud.nosql.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {


    @Pattern(regexp = "^[A-Za-z]+$", message = "solamente permite caracteres de la A - Z")
    private String name;

    @Min(1)
    private Double price;
}
