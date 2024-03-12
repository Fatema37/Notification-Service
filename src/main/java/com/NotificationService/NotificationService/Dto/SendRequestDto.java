package com.NotificationService.NotificationService.Dto;

import lombok.Data;

@Data
public class SendRequestDto {
    private String to;
    private String subject;
    private String body;
}
