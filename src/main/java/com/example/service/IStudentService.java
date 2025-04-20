package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface IStudentService
{
    public List<Student> findAll();

    public void save(Student student);
    public void delete (int studentID);
    public Student findById(int studentID);
    public void update (Student student);
}
