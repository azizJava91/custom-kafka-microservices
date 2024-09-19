package com.messagebroker.kafka.kafkacustom.service;
import com.messagebroker.kafka.kafkacustom.entity.Email;
import com.messagebroker.kafka.kafkacustom.enums.MailSendedValue;
import com.messagebroker.kafka.kafkacustom.repository.EmailRepository;
import com.messagebroker.kafka.kafkacustom.response.EmailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

private final EmailRepository emailRepository;

    @Override
    public void accept(String email) {
        Email saveEmail = Email.builder()
                .email(email)
                .isSended(MailSendedValue.NOTSENDED.getValue)
                .build();
        emailRepository.save(saveEmail);
        System.err.println("accepted");
    }

    @Override
    public List<EmailResponse> waitingEmails() {
        List<Email> emailEntityes = emailRepository.findAllByIsSended(MailSendedValue.NOTSENDED.getValue);

        emailEntityes.forEach(email -> {
            email.setIsSended(MailSendedValue.SENDED.getValue);
            emailRepository.save(email);
        });

          List<EmailResponse> response = emailEntityes.stream().map((this::convert)).toList();
        return response;
    }

    private EmailResponse convert (Email email){
        return EmailResponse.builder()
                .email(email.getEmail()).build();
    }
}
