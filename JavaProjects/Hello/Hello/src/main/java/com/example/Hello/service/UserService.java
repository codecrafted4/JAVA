package com.example.Hello.service;

import com.example.Hello.dto.UserRequest;
import com.example.Hello.models.Users;
import com.example.Hello.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public String addUser(UserRequest users) {
        Users user = Users.builder()
                .userName(users.getUserName())
                .mail(users.getMail())
                .password(users.getPassword())
                .build();
       Users savedUser =userRepository.save(user);
       return "user saved successfully";
    }
}
