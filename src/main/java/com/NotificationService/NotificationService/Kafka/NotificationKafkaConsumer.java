package com.NotificationService.NotificationService.Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class NotificationKafkaConsumer {

    @Autowired
    private JavaMailSender mailSender;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "notification-topic")
    public void receiveNotification(String message) throws JsonProcessingException {
        // Parse the message to extract recipient, subject, and body


        EmailMessage emailMessage = objectMapper.readValue(message, EmailMessage.class);
        // Create a SimpleMailMessage object and send the email
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailMessage.getTo());
        mailMessage.setSubject(emailMessage.getSubject());
        mailMessage.setText(emailMessage.getBody());

        mailSender.send(mailMessage);

        // Process notification message
        System.out.println("Received notification message: " + message);
    }
}
