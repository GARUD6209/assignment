package com.harsh.assignment.service;

import com.harsh.assignment.entity.StudentEntity;
import com.harsh.assignment.entity.SubjectEntity;
import com.harsh.assignment.pojo.internal.Student;
import com.harsh.assignment.pojo.internal.Subject;
import com.harsh.assignment.repo.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String create(Student student) {


        StudentEntity res = studentRepository.save(modelMapper.map(student, StudentEntity.class));

        return res.getName();
    }


    public Set<Student> getAll() {

        List<StudentEntity> studentList = studentRepository.findAll();

        Set<Student> resSet = new HashSet<>();

        for (StudentEntity studentEntity:studentList){
            resSet.add(modelMapper.map(studentEntity,Student.class));

        }


        return resSet;
    }
}
