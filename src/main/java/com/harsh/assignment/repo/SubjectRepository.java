package com.harsh.assignment.repo;

import com.harsh.assignment.entity.SubjectEntity;
import com.harsh.assignment.pojo.internal.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity,Long> {
}
