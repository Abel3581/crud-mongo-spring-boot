package com.crud.nosql.service;

import com.crud.nosql.dto.ProductRequest;
import com.crud.nosql.dto.ProductResponse;
import com.crud.nosql.entity.Product;

import com.crud.nosql.mapper.ProductMapper;
import com.crud.nosql.repository.ProductRepository;
import com.crud.nosql.service.abstraction.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = false)
    @Override
    public void save(ProductRequest request) {
        Product product = ProductMapper.mapTo(request);
        productRepository.save(product);
    }


    @Transactional(readOnly = true)
    @Override
    public Product findById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Producto no encontrado");
        }
        return product.get();
    }

    @Transactional(readOnly = false)
    @Override
    public void saveEntity(Product product) {
        productRepository.save(product);
    }

    @Transactional(readOnly = true)
    @Override
    public ProductResponse getById(String id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Producto no encontrado");
        }
        return ProductMapper.mapToDto(product.get());
    }


}
