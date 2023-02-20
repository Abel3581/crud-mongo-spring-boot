package com.crud.nosql.mapper;

import com.crud.nosql.dto.MessageResponse;
import com.crud.nosql.dto.ProductRequest;
import com.crud.nosql.dto.ProductResponse;
import com.crud.nosql.entity.Message;
import com.crud.nosql.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductMapper {

    public static Product mapTo(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return product;
    }

    public static ProductResponse mapToDto(Product product) {
        ProductResponse response = new ProductResponse();
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setMessageResponses(mapToDtoListMessages(product.getMessageList()));
        return response;
    }

    private static List<MessageResponse> mapToDtoListMessages(List<Message> messageList) {
        List<MessageResponse> responses = new ArrayList<>();
        for (Message m: messageList){
            responses.add(mapToDtoMessage(m));
        }
        return responses;
    }

    private static MessageResponse mapToDtoMessage(Message m) {
        MessageResponse response = new MessageResponse();
        response.setMessage(m.getMessage());
        response.setId(m.getId());
        return response;
    }

}
