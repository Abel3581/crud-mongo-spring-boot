package com.crud.nosql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document(collection = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    private String  id;
    private String name;
    private Double price;

    @DBRef()
    private List<Message> messageList = new ArrayList<>();

    public void addMessage(Message m){
        messageList.add(m);
    }
}
