package com.aloha.security.mapper;

import com.aloha.security.dto.Board;
import com.aloha.security.dto.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> list(Page page) throws Exception;
    // 게시글 조회
    public Board select(int no) throws Exception;
    // 게시글 등록
    public int insert(Board board) throws Exception;
    // 게시글 수정
    public int update(Board board) throws Exception;
    // 게시글 삭제
    public int delete(int no) throws Exception;

    // 게시글 번호(기본키) 최댓값
    public int maxPk() throws Exception;

    //게시글 데이터 개수 조회
    public int count() throws Exception;

}
