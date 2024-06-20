package com.aloha.security.service;

import com.aloha.security.dto.Board;
import com.aloha.security.dto.Option;
import com.aloha.security.dto.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BoardService {


        // 게시글 목록
        public List<Board> list(Page page, Option option) throws Exception;
        // 게시글 조회
        public Board select(int no) throws Exception;
        // 게시글 등록
        public int insert(Board board) throws Exception;
        // 게시글 수정
        public int update(Board board) throws Exception;
        // 게시글 삭제
        public int delete(int no) throws Exception;

        // 게시글 목록 - [검색]
        public List<Board> search(Option option) throws Exception;

        // 조회수 증가
        public int view(int no) throws Exception;

}
