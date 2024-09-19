package com.messagebroker.kafkasubscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkasubscriberApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkasubscriberApplication.class, args);
    }

}
