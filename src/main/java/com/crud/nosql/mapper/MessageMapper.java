package com.crud.nosql.mapper;

import com.crud.nosql.dto.MessageRequest;
import com.crud.nosql.entity.Message;

public class MessageMapper {
    public static Message mapTo(MessageRequest request) {
        Message message = new Message();
        message.setMessage(request.getMessage());
        return message;
    }
}
