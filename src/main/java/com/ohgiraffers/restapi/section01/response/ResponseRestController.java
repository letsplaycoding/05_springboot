package com.ohgiraffers.restapi.section01.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 설명. RestController는 모든 핸들러 메소드에 @ResponseBody를 붙여주는 어노테이션이다. */
/* 설명. 이 Controller의 핸들러 메소드 반환값은 이제 viewResolver가 처리하지 않는다.(JSON 문자열로 반환된다) */
@RestController
@RequestMapping("/response")
public class ResponseRestController {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello World";
    }

    @GetMapping("/random")
    public int getRandomNumber() {
        return (int)(Math.random() * 10) +1;
    }

    @GetMapping("message")
    public Message getMessage() {
        return new Message(200, "메세지를 응답합니다.");
    }

    @GetMapping("test")
    public List<Map<String, Message>> getTest() {
        List<Map<String, Message>> list = new ArrayList<>();
        Map<String, Message> map = new HashMap<>();
        map.put("test1", new Message(200,"success1"));
        map.put("test2", new Message(200,"success2"));
        list.add(map);

        return list;
    }
}
