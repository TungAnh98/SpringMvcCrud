/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.crudspring.controllers;

import com.company.crudspring.exception.RecordNotFoundException;
import com.company.crudspring.model.StudentEntity;
import com.company.crudspring.service.StudentService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Engineer_Account
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService service;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        List<StudentEntity> list = service.getAllStudents();
        return new ResponseEntity<List<StudentEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable("id") int id)
            throws RecordNotFoundException {
        StudentEntity entity = service.getStudentById(id);

        return new ResponseEntity<StudentEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentEntity> createOrUpdateStudent(@Valid @RequestBody StudentEntity student)
            throws RecordNotFoundException {
        StudentEntity updated = service.createOrUpdateStudent(student);
        return new ResponseEntity<StudentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteStudentById(@PathVariable("id") int id)
            throws RecordNotFoundException {
        service.deleteStudentById(id);
        return HttpStatus.FORBIDDEN;
    }
}
