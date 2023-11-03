package org.zerock.myweb.command;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
	
	private int rno;
	private int bno;
	private String reply;
	private String replyer;
	private Date replDate;
	private Date updateDate;
	
}
