package com.harsh.assignment.repo;

import com.harsh.assignment.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository  extends JpaRepository<StudentEntity,Long> {
}
