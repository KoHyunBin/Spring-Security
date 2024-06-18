package com.aloha.security.dto;

/*
    페이지 필수 정보
    페이지 번호
    페이지당 게시글 수
    노출 페이지 개수
    전체 데이터 개수

    페이지 수식 정보
    시작 번호
    끝 번호
    첫 번호
    마지막 번호
 */


public class Page {

    // 페이징 기본값
    private static final int PAGE_NUM = 1; // 현재 페이지 번호 기본값
    private static final int ROWS = 10;
    private static final int COUNT = 10;

    // 필수 정보
    private int page; // 페이지번호
    private int rows; // 페이지당 글 수
    private int count; // 노출 페이지 개수
    private int total; // 전체 데이터 개수

    // 수식 정보
    private int start; // 시작 번호
    private int end; // 끝 번호
    private int first; // 첫 번호
    private int last; // 마지막 번호
    private int prev; // 이전 번호
    private int next; // 다음 번호
    private int index;

    // 생성자
    public Page() {
        this(0);
    }

    //데이터 개수
    public Page(int total) {
        this(PAGE_NUM, total);
    }

    // 현재 번호, 데이터 개수
    public Page(int page, int total) {
        this(page, ROWS, COUNT, total);
    }
    public Page(int page, int rows, int count, int total) {
        this.page = page;
        this.rows = rows;
        this.count = count;
        this.total = total;
        calc();
    }

    //페이징 처리 수식
    public void calc() {
        this.first = 1;
        this.last = (this.total -1 ) / rows + 1;
        this.start = ((page-1) / count) * count + 1;
        this.end = ((page-1) / count + 1) * count;
        this.prev = this.page - 1;
        this.next = this.page + 1;
        this.index = (this.page - 1) * this.rows;
    }
}
