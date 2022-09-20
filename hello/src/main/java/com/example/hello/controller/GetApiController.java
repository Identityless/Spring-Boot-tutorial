package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    @GetMapping(path = "/hello")    // http://localhost:9090/api/get/hello
    public String Hello(){
        return "get Hello";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)  // 예전에 사용하던 주소 맵핑
    public String hi(){
        return "hi";
    }

    @GetMapping("/path-variable/{name}")    // http://localhost:9090/api/get/path-variable/{name}   -> name이 계속 변하는 경우 ( Path Variable )
    public String pathVariable(@PathVariable(name = "name") String pathName, String name){
        System.out.println("PathVariable : "+pathName);
        return pathName;
    }

    // ?key=value&key2=value2......

    // http://localhost:9090/api/get/query-param?user=steve&email=steve@gmail.com&age=30

    @GetMapping(path = "/query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();
        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = " + entry.getValue() + "\n");
        });

        return sb.toString();
    }

    @GetMapping(path = "/query-param02")
    public String queryParam02(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    @GetMapping(path = "/query-param03")    // json으로 받음 (Data Body)
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }

}
