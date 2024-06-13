package com.aloha.security.controller;

import com.aloha.security.dto.Board;
import com.aloha.security.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/*
    /board 경로로 요청 왔을 때 처리
   [GET] - /board/list : 게시글 목록 화면
   [GET] - /board/read : 게시글 조회 화면
   [GET] - /board/insert : 게시글 등록 화면
   [POST] - /board/insert : 게시글 등록 처리
   [GET] - /board/update : 게시글 수정 화면
   [POST] - /board/update : 게시글 수정 처리
   [POST] - /board/delete : 게시글 삭제 처리
*/
@Slf4j                        // 로그 어노테이션
@Controller                   // 컨트롤러 스프링 빈으로 등록
@RequestMapping("/board")     // 클래스 레벨 요청 경로 매핑
                              // -/board/~ 경로의 요청은 이 컨트롤러에서 처리
public class BoardController {

    // Controller --> Service (데이터 요청)
    // Controller <-- Service (데이터 전달)
    // Controller --> Model   (모델 등록)
    // View <-- Model         (데이터 출력)

    @Autowired // 의존성 자동 주입
    private BoardService boardService; //@Service를 --Impl 에 등록
    /*
        게시글 목록 조회 화면
        @return
        @throws Exception
     */
    @GetMapping("/list")
    public String list(Model model) throws Exception{
        //데이터 요청
        List<Board> boardList = boardService.list();
        //모델 등록
        model.addAttribute("boardList", boardList);

        //뷰 페이지 지정
        return "/board/list"; // resources/templates/board/list.html
    }

    /*
        게시글 조회 화면
        [GET] - /board/read?no=
        @param no
        @return
     */
    @GetMapping("/read")
    public String read(@RequestParam("no") int no, Model model) throws Exception {
        //데이터 요청
        Board board = boardService.select(no);
        //모델 등록
        model.addAttribute("board",board);
        //뷰페이지 지정
        return "/board/read";
    }


}
