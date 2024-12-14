package com.harsh.assignment.service;

import com.harsh.assignment.entity.SubjectEntity;
import com.harsh.assignment.pojo.internal.Subject;
import com.harsh.assignment.repo.SubjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String create(Subject subject) {


        SubjectEntity res = subjectRepository.save(modelMapper.map(subject, SubjectEntity.class));

        return res.getName();
    }


    public Set<Subject> getAll() {

        List<SubjectEntity> subjectList = subjectRepository.findAll();

        Set<Subject> resSet = new HashSet<>();

        for (SubjectEntity subjectEntity:subjectList){
            resSet.add(modelMapper.map(subjectEntity,Subject.class));

        }


        return resSet;
    }
}
