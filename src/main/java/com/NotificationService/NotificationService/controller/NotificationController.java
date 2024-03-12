package com.NotificationService.NotificationService.controller;

import com.NotificationService.NotificationService.Dto.SendRequestDto;
import com.NotificationService.NotificationService.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notification")
public class NotificationController {


    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody SendRequestDto requestDto) {
        notificationService.sendEmailNotification(requestDto.getTo(), requestDto.getSubject(), requestDto.getBody());
        return "Email sent successfully";
    }

}
