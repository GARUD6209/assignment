package com.harsh.assignment.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "subject")
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @ManyToMany(mappedBy = "subjectEntities")
    private Set<StudentEntity> studentEntities = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<StudentEntity> getStudentEntities() {
        return studentEntities;
    }

    public void setStudentEntities(Set<StudentEntity> studentEntities) {
        this.studentEntities = studentEntities;
    }
}
