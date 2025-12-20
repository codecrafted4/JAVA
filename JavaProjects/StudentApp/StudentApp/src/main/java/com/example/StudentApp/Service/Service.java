package com.example.StudentApp.Service;

import com.example.StudentApp.Model.Student;
import com.example.StudentApp.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@org.springframework.stereotype.Service
public class Service {
    @Autowired
    Repository studentRepository;

    public Student getStudentById(int id) {
        Student student= studentRepository.getStudentById(id);
        if(student==null) {
            return null;
        }
        return student;
    }
    public String addStudent(Student student)
    {
        return studentRepository.addStudent(student);
    }
    public ArrayList<Student> getStudentList()
    {
        return studentRepository.getStudentList();
    }
    public String deleteId(int id)
    {
        return studentRepository.deleteId(id);
    }
    public String updateAge(int id, int age)
    {
        return studentRepository.updateAge(id,age);
    }
}
