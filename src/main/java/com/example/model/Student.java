package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private double mark;

    @ManyToMany
    List<Book> books;

    public Student() {}

    public  Student(int id, String firstName, String lastName, double mark)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mark = mark;
    }

    public  int getId()
    {
        return id;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public  String getLastName()
    {
        return lastName;
    }
    public  double getMark()
    {
        return mark;
    }
    public  void setId(int id)
    {
        this.id = id;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public void setMark(double mark)
    {
        this.mark = mark;
    }
}
