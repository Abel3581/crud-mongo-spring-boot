package com.crud.nosql.service;

import com.crud.nosql.dto.ProductRequest;
import com.crud.nosql.dto.ProductResponse;
import com.crud.nosql.entity.Product;
import com.crud.nosql.mapper.ProductMapper;
import com.crud.nosql.repository.ProductRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class ProductServiceImplTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductMapper productMapper;

    private Product product;
    private ProductRequest productRequest;
    private ProductResponse productResponse;


    





}
