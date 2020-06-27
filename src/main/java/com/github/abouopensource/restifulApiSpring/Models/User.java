package com.github.abouopensource.restifulApiSpring.Models;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    private Integer id;
    @Size(min = 2,message = "Name should have at least 2 char")
    private String name;

    @Past
    private Date birthday;
    private List<Post> posts;
    protected User() {

    }

    public User(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.posts = new ArrayList<>();
    }

    public User(Integer id, String name, Date birthday, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.posts = posts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
