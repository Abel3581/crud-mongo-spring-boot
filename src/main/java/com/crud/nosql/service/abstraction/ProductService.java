package com.crud.nosql.service.abstraction;

import com.crud.nosql.dto.ProductRequest;
import com.crud.nosql.dto.ProductResponse;
import com.crud.nosql.entity.Product;

public interface ProductService {

    void save(ProductRequest request);

    Product findById(String id);

    void saveEntity(Product product);

    ProductResponse getById(String id);
}
