package com.study.Ex09_Mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.Ex09_Mybatis.dao.ISimpleBbsDao;
import com.study.Ex09_Mybatis.dto.SimpleBbsDto;

@Controller
public class MyController {
	
	@Autowired 
	private ISimpleBbsDao dao;

	@RequestMapping("/")
	public /*@ResponseBody*/ String root() {
		return "redirect:list"; //list URI로 리다이렉트 시킨다.
	}
	
	// URL : localhost:8090/list
	@RequestMapping("/list")
	public String userlist( Model model ) {
		
		model.addAttribute("list", dao.listDao());
		
		return "list"; // list.jsp 를 디스패치함.
	}
	
	@RequestMapping("/view")
	public String view( @RequestParam("id") String id, Model model ) {
		
		model.addAttribute("dto", dao.viewDao(id) );
		
		return "view"; // view.jsp 를 디스패치함.
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm"; // writeForm.jsp 를 디스패치함.
	}
	
	@RequestMapping("/write")
	public String write( @RequestParam("writer") String writer,
						@RequestParam("title") String title,
						@RequestParam("content") String content,
						Model model) {
		
		//SimpleBbsDto dto = new SimpleBbsDto( 0, writer, title, content );
		SimpleBbsDto dto = new SimpleBbsDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		//Mybatis에서 insert, update, delete는 자동으로 int타입의 값을 반환해 준다.
		// resultType="_int"를 설정하지 않아도 됨.  _int : primary type    int : Integer
		int result = dao.writeDto( dto );
		
		//int result = dao.writeDao(writer, title, content);
		System.out.println( "result:" + result); //성공시 insert갯수(1)로 리턴함.
				
		return "redirect:list"; // /list 로 리다이렉트함..
	}
	
	@RequestMapping("/delete")
	public String delete( @RequestParam("id") String id, Model model ) {
		
		dao.deleteDao(id);
		
		return "redirect:list"; // /list 로 리다이렉트함..
	}
	
	@RequestMapping("/updateForm")
	public String updateForm(@RequestParam("id") String id, Model model) {
		
		model.addAttribute("dto", dao.viewDao(id) );
		
		return "updateForm"; // updateForm.jsp 를 디스패치함.
	}
	
	@RequestMapping("/update")
	public String update( 
						@RequestParam("id") String id,
						@RequestParam("writer") String writer,
						@RequestParam("title") String title,
						@RequestParam("content") String content,
						Model model) {
		
		dao.updateDao(id, writer, title, content);
				
		return "redirect:list"; // /list 로 리다이렉트함..
	}
}





