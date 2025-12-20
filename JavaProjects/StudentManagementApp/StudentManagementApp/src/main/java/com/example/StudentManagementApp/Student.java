package com.example.StudentManagementApp;



import org.springframework.stereotype.Repository;


@Repository
public class Student {

    int id=2;
    String  name= "utkarsh" ;
    int age = 27 ;
    int marks =45 ;
    public String addStudent(int id, String name, int age,int marks ) {
        if (this.id == id) return "id already exist";
        else {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
            return "id added sucessfull";
        }
    }
    public String getStudentByIdPath(int id) {

        if(this.id!=id){
            return "id is not available";
        }
        return "id= "+this.id+" name= "+this.name+" age= "+this.age+" marks= "+this.marks;

    }


}
