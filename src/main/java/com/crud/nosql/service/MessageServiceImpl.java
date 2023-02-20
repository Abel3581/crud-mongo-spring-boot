package com.crud.nosql.service;

import com.crud.nosql.dto.MessageRequest;
import com.crud.nosql.entity.Message;
import com.crud.nosql.entity.Product;
import com.crud.nosql.mapper.MessageMapper;
import com.crud.nosql.repository.MessageRepository;
import com.crud.nosql.service.abstraction.MessageService;
import com.crud.nosql.service.abstraction.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ProductService productService;

    @Transactional(readOnly = false)
    @Override
    public void save(String id, MessageRequest request) {
        Product product = productService.findById(id);
        Message message = MessageMapper.mapTo(request);
        product.addMessage(message);
        messageRepository.save(message);
        productService.saveEntity(product);
    }
}
