package com.example.StudentApp.Model;

public class Student {
    int id;
    String name;
    int age;
     int marks;

     public Student(int id, String name, int age, int marks){
         this.id = id;
         this.name = name;
         this.age = age;
         this.marks = marks;
     }
     public int getId()
     {
         return this.id;
     }
     public String getName()
     {
         return this.name;
     }
     public int getAge()
     {
         return this.age;

     }
     public int getMarks()
     {
         return this.marks;
     }
     public void setAge(int age)
     {
         this.age = age;
     }
}
