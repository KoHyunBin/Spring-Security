package com.aloha.security.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Data
public class Board {

    private int no;
    private String title;
    private String writer;
    private String content;
    private Date regDate;
    private Date updDate;
    private int views;

    // 썸네일 이미지 파일
    MultipartFile thumbnail;

    // 파일
    List<MultipartFile> file;

    // 파일 번호
    private int fileNo;
}
