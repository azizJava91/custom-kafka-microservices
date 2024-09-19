package com.messagebroker.kafka.kafkacustom.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor


public enum MailSendedValue {
    SENDED (1L),
    NOTSENDED(0L);
    public Long getValue;
}
