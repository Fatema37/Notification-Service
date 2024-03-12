package com.NotificationService.NotificationService.services;

import com.NotificationService.NotificationService.Kafka.EmailMessage;
import com.NotificationService.NotificationService.Kafka.NotificationKafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceKafka {
    @Autowired
    private NotificationKafkaProducer notificationKafkaProducer;

    public void sendKafkaNotification(String to, String subject, String body) throws JsonProcessingException {
        EmailMessage message = new EmailMessage();
        message.setTo(to);
        message.setBody(body);
        message.setSubject(subject);
        notificationKafkaProducer.sendNotification(message);
    }


}
