package com.messagebroker.kafka.kafkacustom.service;


import com.messagebroker.kafka.kafkacustom.response.EmailResponse;

import java.util.List;

public interface EmailService {
    void accept(String email);

    List<EmailResponse> waitingEmails();
}
