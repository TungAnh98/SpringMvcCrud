/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.crudspring.service;

import com.company.crudspring.exception.RecordNotFoundException;
import com.company.crudspring.model.StudentEntity;
import com.company.crudspring.repository.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jdk.nashorn.internal.runtime.regexp.joni.constants.OPSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Engineer_Account
 */
@Service
public class StudentService {

    @Autowired
    StudentRepository repository;

    public List<StudentEntity> getAllStudents() {
        List<StudentEntity> studentList = repository.findAll();
        if (studentList.size() > 0) {
            return studentList;
        } else {
            return new ArrayList<StudentEntity>();
        }
    }

    public StudentEntity getStudentById(Integer id) throws RecordNotFoundException {
        Optional<StudentEntity> student = repository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RecordNotFoundException("No student record exist for given id", id);
        }
    }

    public StudentEntity createOrUpdateStudent(StudentEntity entity)  {

//        if (entity.getId()!=null) {
            Optional<StudentEntity> student = repository.findById(entity.getId());

            if (student.isPresent()) {
                StudentEntity newEntity = student.get();
                newEntity.setEmailId(entity.getEmailId());
                newEntity.setFirstName(entity.getFirstName());
                newEntity.setLastName(entity.getLastName());
                newEntity.setBranch(entity.getBranch());

                newEntity = repository.save(newEntity);

                return newEntity;
            } else {
                entity = repository.save(entity);

                return entity;
            }
//        } else {
//            entity = repository.save(entity);
//            return entity;
//        }
    }

    public void deleteStudentById(int id) throws RecordNotFoundException {
        Optional<StudentEntity> student = repository.findById(id);

        if (student.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No student record exist for given id", id);
        }
    }
}
