package com.example.service;

import com.example.model.Student;
import com.example.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final IStudentRepository iStudentRepository;

    @Autowired
    public StudentService(IStudentRepository iStudentRepository) {
        this.iStudentRepository = iStudentRepository;
    }

    @Override
    @Transactional
    public void save(Student student) {
        System.out.println("StudentService: Đang lưu sinh viên " + student);
        iStudentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return iStudentRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Student student) {
        iStudentRepository.save(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        iStudentRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        Optional<Student> studentOptional = iStudentRepository.findById(id);
        return studentOptional.orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với ID: " + id));
    }
}