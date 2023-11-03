package org.zerock.myweb.command;

import java.sql.Timestamp;

public class BoardVO {
	
	// VO객체는 DB컬럼과 1:1 매칭이 되도록 생성합니다. 
	// VO객체는 반드시 DB컬럼명과 동일하게 만들어 사용합니다. 
	// VO객체는 은닉변수로 선언, getter, setter를 이용하여 처리
	// VO객체는 모든 맴버젼수를 초기화하는 생성자, 기본 생성자 2개를 선언합니다. 
	
	private int num;
	private String title;
	private String content;
	private String writer;
	private Timestamp regdate;
	private Timestamp updatedate;
	
	public BoardVO() {}

	public BoardVO(int num, String title, String content, String writer, Timestamp regdate, Timestamp updatedate) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regdate = regdate;
		this.updatedate = updatedate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "BoardVO [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
				+ regdate + ", updatedate=" + updatedate + "]";
	}
	
}
