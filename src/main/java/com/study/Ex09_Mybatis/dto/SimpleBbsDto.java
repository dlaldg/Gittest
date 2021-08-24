package com.study.Ex09_Mybatis.dto;

import lombok.Data;

@Data
public class SimpleBbsDto {
	private int id;
	private String writer;
	private String title;
	private String content;
	
	public SimpleBbsDto() {
		
	}
	
	public SimpleBbsDto(int id, String writer, String title, String content) {
		super();
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
	}
	
	//Getter/Setter는 자동생성
}
