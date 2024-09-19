package com.messagebroker.kafkapublisher.response;

import lombok.Data;

@Data
public class Response<T>{
    private T t;
    String notificationText;
}
