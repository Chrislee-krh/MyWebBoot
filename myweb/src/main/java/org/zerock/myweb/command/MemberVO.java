package org.zerock.myweb.command;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter  //getter
//@Setter  //setter
//@NoArgsConstructor  //기본생성자
//@AllArgsConstructor //전체 필드 생성자 
@Data   //getter, setter, 기본생성자, equals, toString...
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private Timestamp regdate;
	
}
