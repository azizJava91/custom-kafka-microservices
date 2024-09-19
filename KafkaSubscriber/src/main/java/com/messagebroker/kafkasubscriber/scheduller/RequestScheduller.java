package com.messagebroker.kafkasubscriber.scheduller;
import com.messagebroker.kafkasubscriber.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@RequiredArgsConstructor
@Component
public class RequestScheduller {

    private final EmailService emailService;

    @Scheduled(cron = "*/30 * * * * ?")
    private void pullEmails() throws URISyntaxException {
        emailService.pullEmails();
        System.err.println("pulled");
    }
}
