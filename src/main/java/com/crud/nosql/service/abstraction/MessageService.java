package com.crud.nosql.service.abstraction;

import com.crud.nosql.dto.MessageRequest;

public interface MessageService {
    void save(String id, MessageRequest request);
}
