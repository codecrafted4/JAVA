package com.example.Hello.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {
    private int senderId;
    private int recieverId;
    private String content;
}
