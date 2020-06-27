package com.github.abouopensource.restifulApiSpring.Controllers;

import com.github.abouopensource.restifulApiSpring.Models.Post;
import com.github.abouopensource.restifulApiSpring.service.PostDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class PostResource {
    @Autowired
    private PostDaoService service;


    @GetMapping("/users/{id}/posts")
    public List<Post> retrieveAllUsers(@PathVariable int id){

        return service.findAll(id);
    }

}
