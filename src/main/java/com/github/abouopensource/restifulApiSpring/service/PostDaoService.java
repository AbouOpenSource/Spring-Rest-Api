package com.github.abouopensource.restifulApiSpring.service;

import com.github.abouopensource.restifulApiSpring.Models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostDaoService {
    @Autowired
    UserDaoService  service;

    public List<Post> findAll(int id){

        return service.findOne(id).getPosts();
    }


}
