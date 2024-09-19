package com.messagebroker.kafkasubscriber.service;

import com.messagebroker.kafkasubscriber.entity.PulledEmail;
import com.messagebroker.kafkasubscriber.enums.MailSendedValue;
import com.messagebroker.kafkasubscriber.repository.PulledEmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {

    private final PulledEmailRepository pulledEmailRepository;
    private static final String BROKER_URL = "http://localhost:8089/kafka/email/waiting";

    @Override
    public void pullEmails() throws URISyntaxException {
        List<String> emailList = new ArrayList<>();
        URI uri = new URI(BROKER_URL);
        RestTemplate restTemplate = new RestTemplate();

        List<Map<String, String>> responseList = restTemplate.getForEntity(uri, List.class).getBody();

        if (responseList != null) {
            for (Map<String, String> map : responseList) {
                emailList.add(map.get("email"));
            }
        }

        emailList.forEach(this::sendMail);

        emailList.forEach(email -> {
            PulledEmail pulledEmail = new PulledEmail();
            pulledEmail.setEmail(email);
            pulledEmail.setIsSended(MailSendedValue.SENDED.getValue);

            pulledEmailRepository.save(pulledEmail);
        });
    }


    private void sendMail(String email) {
        System.out.println("verification mail sended to : " + email + " address");
    }

}
