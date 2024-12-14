package com.harsh.assignment.pojo.auth;


import lombok.Data;

@Data
public class SignupResponse {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
