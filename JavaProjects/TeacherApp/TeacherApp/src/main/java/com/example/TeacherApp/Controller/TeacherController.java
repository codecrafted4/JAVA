package com.example.TeacherApp.Controller;

import com.example.TeacherApp.Model.Teacher;
import com.example.TeacherApp.Service.TeacherService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/v2/teacher")

public class TeacherController {
    @Autowired
    TeacherService service;

    Logger logger = (Logger) LoggerFactory.getLogger(TeacherController.class);

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable ("id") int id){
        return service.getTeacherById(id);
    }

    @PostMapping
    public String addTeacher(@RequestBody Teacher teacher) {
        logger.info("Teacher input Recieved"+ teacher);
        return service.addTeacher(teacher);
    }
    @DeleteMapping("/delete/{id}")
    public String DeleteById(@PathVariable("id") int id){
        if(getTeacherById(id)==null){
            return "Id does not exist";
        }
        return service.deleteById(id);
    }
    @GetMapping("/list")
    public ArrayList<Teacher> allTeacher(){
        return service.allTeacher();
    }
}
