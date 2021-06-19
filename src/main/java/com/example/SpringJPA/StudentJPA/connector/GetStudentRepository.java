package com.example.SpringJPA.StudentJPA.connector;

import com.example.SpringJPA.StudentJPA.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface GetStudentRepository extends CrudRepository<Student, Integer> {

}
