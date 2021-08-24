package com.study.Ex09_Mybatis.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.study.Ex09_Mybatis.dto.SimpleBbsDto;

//@Mapper : MyBatis와 인터페이스 함수를 연결함.
@Mapper
public interface ISimpleBbsDao {

	public List<SimpleBbsDto> listDao();
	public SimpleBbsDto viewDao(String id);
	public int writeDto(SimpleBbsDto dto);
	public int writeDao(String writer, String title, String content);
	public int deleteDao(String id);
	public int updateDao(String id, String writer, String title, String content);
	
}
