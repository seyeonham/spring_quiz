package com.quiz.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02RestController {

	// http://localhost:8080/lesson01/quiz02/1
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 0);
		map.put("director", "로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 12);
		map.put("director", "크리스퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		list.add(map);
		
		map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "프린시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");
		list.add(map);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/2
	@RequestMapping("/2")
	public List<Person> quiz02_2() {
		// @ResponseBody + return String => (HttpMessageConverter) => HTML
		// @ResponseBody + return 객체(Map, List, Class) => (HttpMessageConverter) => (Jackson 라이브러리) =>  JSON
		List<Person> list = new ArrayList<>();
		
		Person person = new Person();
		person.setTitle("안녕하세요 가입인사 드립니다.");
		person.setUser("marobiana");
		person.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		list.add(person);
		
		person = new Person();
		person.setTitle("헐 대박");
		person.setUser("bada");
		person.setContent("오늘 목요일이었어... 금요일인줄");
		list.add(person);
		
		person = new Person();
		person.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		person.setUser("dulumary");
		person.setContent("...");
		list.add(person);
		
		return list;
	}
	
	// http://localhost:8080/lesson01/quiz02/3
	@RequestMapping("/3")
	public ResponseEntity<Person> quiz02_3() {
		Person person = new Person();
		person.setTitle("안녕하세요 가입인사 드립니다.");
		person.setUser("marobiana");
		person.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		
		return new ResponseEntity<>(person, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
