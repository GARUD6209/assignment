package com.harsh.assignment.repo;

import com.harsh.assignment.entity.SignupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<SignupEntity,Long> {

}
