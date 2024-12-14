package com.harsh.assignment.service;

import com.harsh.assignment.entity.SignupEntity;
import com.harsh.assignment.pojo.auth.SignupRequest;
import com.harsh.assignment.pojo.auth.SignupResponse;
import com.harsh.assignment.repo.AuthRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JdbcUserDetailsManager userDetailsManager; // Inject JdbcUserDetailsManager

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public SignupResponse save(SignupRequest signupRequest){

        SignupEntity signupEntity = modelMapper.map(signupRequest, SignupEntity.class);

        signupEntity.setPassword(passwordEncoder.encode(signupEntity.getPassword()));


        SignupEntity signupEntitySaved = authRepository.save(signupEntity);
        return modelMapper.map(signupEntitySaved, SignupResponse.class);
    }


}