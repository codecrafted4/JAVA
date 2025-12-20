package com.example.TeacherApp.Repository;


import com.example.TeacherApp.Model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class TeacherRepo {

    HashMap<Integer, Teacher> teacherDb = new HashMap<>();

    public Teacher getTeacherById(int id){
        if(!teacherDb.containsKey(id)){
            return null;
        }
        return teacherDb.get(id);
    }
    public String addTeacher(Teacher teacher){
        if(teacherDb.containsKey(teacher.getId())){
            return "Teacher already exists";
        }
        teacherDb.put(teacher.getId(),teacher);
        return "teacher added Successfully";
    }
    public String deleteById(int id) {
        teacherDb.remove(id);
        return "Removed Successfully";
    }
    public ArrayList<Teacher> allTeacher()
    {
//        if(teacherDb.isEmpty()){
//            return null;
//        }
        return new ArrayList<>(teacherDb.values());
    }
}
