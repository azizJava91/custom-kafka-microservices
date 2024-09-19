package com.messagebroker.kafkasubscriber.service;


import java.net.URISyntaxException;

public interface EmailService {
    void pullEmails() throws URISyntaxException;


}
