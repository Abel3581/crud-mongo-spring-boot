package com.crud.nosql.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductResponse {


    private String name;

    private Double price;

    private List<MessageResponse> messageResponses;

}
