package com.example.StudentManagementApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    Student student;

    public String getStudentByIdPath(int id){
        return student.getStudentByIdPath(id);
    }
}
