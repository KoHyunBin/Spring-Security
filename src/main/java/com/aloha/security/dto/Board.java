package com.aloha.security.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Board {

    private int no;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;
}
