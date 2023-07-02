package com.test.caizq.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class StartController {
 
    @RequestMapping("/springboot")
    public String startSpringBoot() throws InterruptedException {
        return "Welcome to the world of Spring Boot!";
    }
    
    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id) {
    	
    	System.out.println("获取到了id是2："+id);
    	return id+"" ;
    }
    
    @GetMapping("/user/{ids}/{name}")
    public String testPathVariable02(@PathVariable(value= "ids") Integer id, @PathVariable String name) {
    	
    	return id+"："+name;
    	
    }
    
    @GetMapping("/user")   //用于 /xxx?iddd=xxx的请求
    public String testRequestParm(@RequestParam(value="iddd", required = false) Integer id) {
    	return id+"";
    }
    
    @PostMapping("/form1")
    public String testForm(@RequestParam String username, @RequestParam String password) {
    	return "username"+"："+password;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
