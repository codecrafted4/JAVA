package com.example.StudentApp.Repository;

import com.example.StudentApp.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

@org.springframework.stereotype.Repository
public class Repository {

    HashMap<Integer,Student> studentDb = new HashMap<>();
    public Student getStudentById(int id) {
        if(!studentDb.containsKey(id)){
            return null;
        }
        return studentDb.get(id);

    }

    public String addStudent(Student student) {
        if(studentDb.containsKey(student.getId())) {
            return "this student is already added";
        }
        studentDb.put(student.getId(),student);
        return "Student Added Successfully";
    }
    public ArrayList<Student> getStudentList(){
        return new ArrayList<>(studentDb.values());
    }
    public String deleteId(int id)
    {
        if(!studentDb.containsKey(id)){
            return "this id does not exist";
        }
        studentDb.remove(id);
        return "Student deleted successful";
    }
    public String updateAge(int id,int age){
        Student ExistingStudent = studentDb.get(id);
        ExistingStudent.setAge(age);
        studentDb.put(id,ExistingStudent);
        return "Age Updated Successfully";

    }
}
