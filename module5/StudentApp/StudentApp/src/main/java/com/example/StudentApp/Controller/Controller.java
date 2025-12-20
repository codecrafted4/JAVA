package com.example.StudentApp.Controller;

import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")

public class Controller {

    @Autowired
    Service service;

    @GetMapping()
    public String getwelcome()
    {
        return "Welcome Student";
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        return service.getStudentById(id);

    }
    @PostMapping
    public String addStudent(@RequestBody Student student)
    {
        return service.addStudent(student);
    }

    @GetMapping("/list")
    public ArrayList<Student> getStudentList()
    {
        return service.getStudentList();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteId(@PathVariable("id") int id){
        return service.deleteId(id);
    }
    @PutMapping("/id/{id}/age/{age}")
    public String updateAge(@PathVariable("id") int id,@PathVariable("age") int age)
    {
        if(getStudentById(id) == null){
            return "id does not exist";
        }
        return service.updateAge(id,age);
    }


}