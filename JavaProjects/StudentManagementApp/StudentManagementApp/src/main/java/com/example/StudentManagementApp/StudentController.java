package com.example.StudentManagementApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class StudentController {



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
//
//    @GetMapping("/student")
//    public Student getStudentById(@RequestParam("id") int id){
//        if(!studentDb.containsKey(id)){
//            return null;
//        }
//        return studentDb.get(id);
//
//    }


    @Autowired
    StudentService studentservice;

    @GetMapping("/student/{id}")
    public String getStudentByIdPath(@PathVariable("id") int id){
        return studentservice.getStudentByIdPath(id);
    }

}
