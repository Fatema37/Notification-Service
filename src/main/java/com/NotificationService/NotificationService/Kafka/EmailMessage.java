package com.NotificationService.NotificationService.Kafka;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
public class EmailMessage {
    private String to;
    private String subject;
    private String body;

//    public EmailMessage(String to, String subject, String body) {
//        this.to = to;
//        this.subject = subject;
//        this.body = body;
//    }


}
