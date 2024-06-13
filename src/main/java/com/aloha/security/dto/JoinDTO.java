package com.aloha.security.dto;

import com.aloha.security.service.JoinService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class JoinDTO {
    private int no;
    private String username;
    private String password;
    private String role;

    public JoinDTO(){

    }

    public JoinDTO(JoinDTO joinDTO){
        this.no = joinDTO.getNo();
        this.username = joinDTO.getUsername();
        this.password = joinDTO.getPassword();
        this.role = joinDTO.getRole();
    }
}
