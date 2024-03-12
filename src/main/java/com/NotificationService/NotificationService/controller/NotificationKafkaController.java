package com.NotificationService.NotificationService.controller;

import com.NotificationService.NotificationService.Dto.SendRequestDto;
import com.NotificationService.NotificationService.services.NotificationServiceKafka;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notification")
public class NotificationKafkaController {

    private NotificationServiceKafka notificationService;

    @Autowired
    public NotificationKafkaController(NotificationServiceKafka notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendKafka")
    public String sendKafkaNotification(@RequestBody SendRequestDto sendRequestDto) throws JsonProcessingException {
        notificationService.sendKafkaNotification(sendRequestDto.getTo(), sendRequestDto.getSubject(), sendRequestDto.getBody());
        return "Email sent successfully";
    }

}
