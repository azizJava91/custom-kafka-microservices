package com.messagebroker.kafka.kafkacustom.controller;


import com.messagebroker.kafka.kafkacustom.response.EmailResponse;
import com.messagebroker.kafka.kafkacustom.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("kafka/email")
@RequiredArgsConstructor
public class EmailController {

private final EmailService emailService;

    @PostMapping("/accept")
    public ResponseEntity accept(@RequestBody String email){

        emailService.accept(email);
       return ResponseEntity.ok("success");
    }

    @GetMapping("waiting")
    public List<EmailResponse> waitingEmails(){
      return emailService.waitingEmails();
    }

}
