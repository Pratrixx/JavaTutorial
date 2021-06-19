package com.example.SpringJPA.StudentJPA.controller;

import com.example.SpringJPA.StudentJPA.model.Student;
import com.example.SpringJPA.StudentJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController<employee> {

    @Autowired
    StudentService employeeService;

    @GetMapping("/getEmpDetails/{studentId}")
    public ResponseEntity<Student> getEmpDetails(@PathVariable Integer studentId) {
        return new ResponseEntity<>(employeeService.getStudentDetails(studentId),HttpStatus.OK);
    }

    @GetMapping("/getAllDetails")
    public ResponseEntity<List<Student>>  getDetails() {
        return new ResponseEntity<List<Student>>(employeeService.getDetails(),HttpStatus.OK);
    }

    @PostMapping("/createStudentDetails")
    public ResponseEntity<String> createStudentDetails(@RequestBody Student student ){
        String s = employeeService.createStudentDetail(student);
        return new ResponseEntity<String>(s,HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateStudentDetails/{studentID}")
    public ResponseEntity<String> updateStudentDetails(@PathVariable Integer studentID, @RequestBody Student student) {
        return new ResponseEntity<String>(employeeService.updateStudentdetail(studentID,student),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteStudentDetails/{studentID}")
    public ResponseEntity<String> deleteStudentDetails(@PathVariable Integer studentID){
        return new ResponseEntity<String>(employeeService.deleteStudentDetail(studentID),HttpStatus.ACCEPTED);
    }
}