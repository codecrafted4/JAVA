package com.example.TeacherApp.Service;

import com.example.TeacherApp.Model.Teacher;
import com.example.TeacherApp.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepo repo;

    public Teacher getTeacherById(int id)
    {
        return repo.getTeacherById(id);
    }

    public String addTeacher(Teacher teacher)
    {
        return repo.addTeacher(teacher);
    }
    public String deleteById(int id){
        return repo.deleteById(id);

    }
    public ArrayList<Teacher> allTeacher() {
        return repo.allTeacher();
    }

}
