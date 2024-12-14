package com.harsh.assignment.controller;

import com.harsh.assignment.constant.ErrorCodeEnum;
import com.harsh.assignment.constant.Role;
import com.harsh.assignment.exception.AssignmentException;
import com.harsh.assignment.jwt.AuthTokenFilter;
import com.harsh.assignment.jwt.JwtUtils;
import com.harsh.assignment.pojo.auth.LoginRequest;
import com.harsh.assignment.pojo.auth.LoginResponse;
import com.harsh.assignment.pojo.auth.SignupRequest;
import com.harsh.assignment.pojo.auth.SignupResponse;
import com.harsh.assignment.service.AuthService;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtils jwtUtils;


    @Autowired
    private ModelMapper modelMapper;

    private static final Logger log = LoggerFactory.getLogger(AuthTokenFilter.class);

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(@RequestBody SignupRequest signupRequest) {
        // Check if user already exists
        if (((JdbcUserDetailsManager) userDetailsService).userExists(signupRequest.getUsername())) {

            throw new AssignmentException(ErrorCodeEnum.USER_ALDEADY_EXIST.getErrorCode(),
                    ErrorCodeEnum.USER_ALDEADY_EXIST.getErrorMessage(), HttpStatus.CONFLICT);
        }

        SignupResponse save = authService.save(signupRequest);
        // Create a new user


        if (((JdbcUserDetailsManager) userDetailsService).userExists(signupRequest.getUsername())) {
            UserDetails user = User.withUsername(signupRequest.getUsername())
                    .password(passwordEncoder.encode(signupRequest.getPassword()))
                    .roles(Role.STUDENT.getRole())
                    .build();
            ((JdbcUserDetailsManager) userDetailsService).updateUser(user);
            log.info("user created with username : " + signupRequest.getUsername());
        }
        return ResponseEntity.ok(save);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication;
        try {
            authentication = authenticationManager
                    .authenticate(new
                            UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()));
            log.info("got to login try block");
        } catch (AuthenticationException exception) {
            Map<String, Object> map = new HashMap<>();
            map.put("message", "Bad credentials");
            map.put("status", false);
            log.error("got to login catch block : " + exception.getMessage());
            return new ResponseEntity<Object>(map, HttpStatus.NOT_FOUND);
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String jwtToken = jwtUtils.generateTokenFromUsername(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        LoginResponse response = new LoginResponse(
                      jwtToken,
                      userDetails.getUsername(),
                      roles );

        return ResponseEntity.ok(response);
    }


}
