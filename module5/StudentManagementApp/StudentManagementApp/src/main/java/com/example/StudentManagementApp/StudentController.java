package com.example.StudentManagementApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class StudentController {

    HashMap<Integer,Student> studentDb = new HashMap<>();

//    @GetMapping("/welcome")
//    public String getWelcome(){
//        return "Welcome";
//    }
//
//    @GetMapping("/addition")
//    public int addition() {
//        int a = 100;
//        int b = 200;
//        return a + b;
//    }

    @GetMapping("/student")
    public Student getStudentById(@RequestParam("id") int id){
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);
    }

}
