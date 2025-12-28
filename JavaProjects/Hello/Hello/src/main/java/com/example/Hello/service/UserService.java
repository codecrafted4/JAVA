package com.example.Hello.service;

import com.example.Hello.dto.UserRequest;
import com.example.Hello.models.Users;
import com.example.Hello.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    public String addUser(UserRequest users) {
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        Users user = Users.builder()
                .userName(users.getUserName())
                .mail(users.getMail())
                .password(encodedPassword)
                .build();
       Users savedUser =userRepository.save(user);
       return "user saved successfully";
    }
}
