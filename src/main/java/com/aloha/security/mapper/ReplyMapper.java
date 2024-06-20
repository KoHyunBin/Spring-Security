package com.aloha.security.mapper;

import com.aloha.security.dto.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyMapper {

    // 댓글 목록
    public List<Reply> list() throws Exception;

    // 댓글 조회
    public Reply select(int no) throws Exception;

    // 댓글 생성
    public int insert(Reply reply) throws Exception;

    // 댓글 변경
    public int update(Reply reply) throws Exception;

    // 댓글 삭제
    public int delete(Reply reply) throws Exception;

}
