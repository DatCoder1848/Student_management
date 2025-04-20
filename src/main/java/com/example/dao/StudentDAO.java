package com.example.dao;

import com.example.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO {

    @PersistenceContext
    private EntityManager em;

    public StudentDAO() {
        System.out.println("StudentDAO bean created");
    }

    public void save(Student student) {
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Error in save: " + ex.getMessage());
        }
    }

    public List<Student> getStudents() {
        List<Student> students = null;
        try {
            students = em.createQuery("from Student", Student.class).getResultList();
        } catch (Exception ex) {
            System.out.println("Error in getStudents: " + ex.getMessage());
        }
        return students != null ? students : new ArrayList<>();
    }

    public void delete(int studentID) {
        try {
            em.getTransaction().begin();
            Student s = em.find(Student.class, studentID);
            if (s != null) {
                em.remove(s);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error in delete: " + ex.getMessage());
        }
    }

    public Student findById(int studentID) {
        try {
            return em.find(Student.class, studentID);
        } catch (Exception ex) {
            System.out.println("Error in findById: " + ex.getMessage());
            return null;
        }
    }

    public void update(Student student) {
        try {
            em.getTransaction().begin();
            Student s = em.find(Student.class, student.getId());
            if (s != null) {
                s.setFirstName(student.getFirstName());
                s.setLastName(student.getLastName());
                s.setMark(student.getMark());
                em.merge(s);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Error in update: " + ex.getMessage());
        }
    }
}