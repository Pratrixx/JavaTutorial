package com.example.SpringJPA.StudentJPA.service;

import com.example.SpringJPA.StudentJPA.connector.GetStudentRepository;
import com.example.SpringJPA.StudentJPA.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    GetStudentRepository getStudentRepository;

    public Student getStudentDetails(Integer studentId) {

        Optional<Student> student = getStudentRepository.findById(studentId);
        if (!ObjectUtils.isEmpty(student)) {
            return student.get();
        }
        return null;

    }

    public List<Student> getDetails() {
        Iterable<Student> students = getStudentRepository.findAll();
        return (List<Student>) students;
    }

    public String createStudentDetail(Student student) {
        try {
            getStudentRepository.save(student);
            return "Saved!!!1";
        } catch (Exception e) {
            System.out.println("Error occured while inerting");

        }
        return null;
    }

    public String updateStudentdetail(Integer studentID, Student student) {
        student.setStudentId(studentID);
        Optional<Student> student1 = getStudentRepository.findById(studentID);
        try {
            if (!student1.isPresent()) {
                return "Record not present";
            } else {
                student1.ifPresent((Student s) -> {
                    getStudentRepository.save(student);
                });
                return "Updated";
            }
        } catch (Exception e) {
            System.out.println("Error occured while updating");
        }
        return null;
    }

    public String deleteStudentDetail(Integer studentID) {
        Optional<Student> student = getStudentRepository.findById(studentID);
        if (!ObjectUtils.isEmpty(student)) {
            getStudentRepository.deleteById(studentID);
            return "Deleted successfully";
        } else {
            return "record not found";

        }
    }
}
