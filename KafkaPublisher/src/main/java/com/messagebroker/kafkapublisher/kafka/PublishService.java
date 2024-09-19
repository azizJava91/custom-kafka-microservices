package com.messagebroker.kafkapublisher.kafka;

import com.messagebroker.kafkapublisher.entity.User;

public interface PublishService {
    void send(String email);
}
