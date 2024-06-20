package com.aloha.security.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Reply {

    private int no;
    private int boardNo;
    private int parentNo;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
}

