package com.example.TeacherApp.Model;

public class Teacher {
    int id;
    String name;
    int age;
    String department;
    String subject;

    public Teacher(int id, String name, int age, String department,String subject){
        this.id = id;
        this.name = name;
        this.age = age;
        this.department=department;
        this.subject= subject;
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
    public String getDepartment()
    {
        return this.department;
    }
    public String getSubject()
    {
        return this.subject;
    }
}
