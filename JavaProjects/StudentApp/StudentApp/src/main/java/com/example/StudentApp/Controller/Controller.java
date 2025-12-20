package com.example.StudentApp.Controller;

import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Service.Service;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/student")



public class Controller {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Controller.class);

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

        logger.trace("trace log");
        logger.debug("debug log");
        logger.info("Student Input Recieved");
        logger.warn("warn log");
        logger.error("error log");
        return service.addStudent(student);
    }

    @GetMapping("/list")
    public ArrayList<Student> getStudentList()
    {
        logger.info("list of student recieved");
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