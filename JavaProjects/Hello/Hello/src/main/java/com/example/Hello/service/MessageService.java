package com.example.Hello.service;

import com.example.Hello.dto.ChatMessage;
import com.example.Hello.exception.UserNotFoundException;
import com.example.Hello.models.Message;
import com.example.Hello.models.Users;
import com.example.Hello.repository.MessageRepository;
import com.example.Hello.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    public String sendMessage(ChatMessage chat) {
        Optional<Users> usersOptional =  userRepository.findById(chat.getRecieverId());
        Optional<Users> usersOptional1 = userRepository.findById(chat.getSenderId());
        if(usersOptional.isEmpty()){
            throw new UserNotFoundException("invalid RecieverId");

        }
        if(usersOptional1.isEmpty()){
            throw new UserNotFoundException("invaid SenderId");
        }
        Users RecieverUser = usersOptional.get();
        Users SenderUser = usersOptional1.get();
        Message message = Message.builder()
                .sender(SenderUser)
                .receiver(RecieverUser)
                .content(chat.getContent())
                .build();
        Message savedChat = messageRepository.save(message);
        return "message send successfully";



    }
}
