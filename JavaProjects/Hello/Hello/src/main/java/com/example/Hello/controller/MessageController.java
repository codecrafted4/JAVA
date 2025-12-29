package com.example.Hello.controller;

import com.example.Hello.dto.ChatMessage;
import com.example.Hello.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hello")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;
    @PostMapping
    public ResponseEntity sendMessage(@RequestBody ChatMessage chat){
        try{
            return new ResponseEntity(messageService.sendMessage(chat), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/app")
    public String helloMessage(){
        return "welcome to hello app";
    }

}
