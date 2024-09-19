package com.messagebroker.kafkapublisher.kafka;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PublishServiceImpl implements PublishService {
    private static final String BROKER_URL = "http://localhost:8089/kafka/email/accept";

    @Override
    public void send(String email) {


        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForObject(BROKER_URL,email, String.class);

    }
}
