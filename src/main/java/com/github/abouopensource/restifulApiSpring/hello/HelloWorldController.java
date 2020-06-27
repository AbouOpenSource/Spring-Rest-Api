package com.github.abouopensource.restifulApiSpring.hello;
//Controller


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;


    //GET
    //URI - /hello-world
    //method - "Hello World"
   // @RequestMapping(method= RequestMethod.GET, path = "/hello-world")
    @GetMapping(path = "/hello-world ")
    public String helloWorld(){
        return "Hello Word";
    }
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Word");
    }

    @GetMapping(path = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello Word %s",name));
    }


/*
    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("good.morning.message",null,locale);
    }
*/

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized(){
        return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
    }
}
