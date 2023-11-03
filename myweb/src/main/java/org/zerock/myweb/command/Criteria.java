package org.zerock.myweb.command;

public class Criteria {
	
	// 페이지당 게시글 수의 기준.... 
	
	//mysql, mariadb : select * from tbl_board by num desc limit ?, ?;
	
	private int pageNum;    //페이지 번호
	private int count;		//페이지 당 게시글 수... 
	
	//기본 생성자
	public Criteria() {
		//최초 게시판에 진입시 기본값 설정. 1번페이지 10개의 게시글
		this.pageNum = 1;
		this.count = 10;
	}

	//필드 생성자
	public Criteria(int pageNum, int count) {
		//전달된 매개변수를 이용한 페이지 값 출력
		this.pageNum = pageNum;
		this.count = count;
	}

	// 페이지내 시작 게시글 인덱스... 
	public int getPageStart() {
//		return ((pageNum - 1)*count);   //mysql, mariadb에서 사용 : limit를 사용할 경우
		return ((pageNum - 1)*count) + 1;  //오라클에서... 두번째 시작 위치를 가리키는 값으로 사용.
	}
	
	public int getPageEnd() {  //오라클을 위해서 생성... 
		return pageNum * count;
	}
	
	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
