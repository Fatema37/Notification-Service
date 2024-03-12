package com.NotificationService.NotificationService.Kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class NotificationKafkaProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public void sendNotification(EmailMessage message) throws JsonProcessingException {
        String messageString = objectMapper.writeValueAsString(message);
        kafkaTemplate.send("notification-topic", messageString);
    }
}
