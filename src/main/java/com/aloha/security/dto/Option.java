package com.aloha.security.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Option {
    private String keyword;
    private int code;

    public Option(){
        this.keyword = "";
    }
}
