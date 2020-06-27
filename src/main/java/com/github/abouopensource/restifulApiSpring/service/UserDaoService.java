package com.github.abouopensource.restifulApiSpring.service;

import com.github.abouopensource.restifulApiSpring.Models.Post;
import com.github.abouopensource.restifulApiSpring.Models.User;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount =6;
   /* static {
        users.add(new User(1,"Kane Mah",new Date()));
        users.add(new User(2,"SANOU Yacouba",new Date()));
        users.add(new User(3,"Mah",new Date()));
        users.add(new User(4,"Kane",new Date()));
        users.add(new User(5,"Anna",new Date()));
        users.add(new User(6,"Bintou",new Date()));

    }*/
    static {
        users.add(new User(1,"Kane Mah",new Date(), Arrays.asList(new Post[]{new Post(1,1,"post1"),new Post(2,1,"post2")})));
        users.add(new User(2,"SANOU Yacouba",new Date(), Arrays.asList(new Post[]{new Post(3,2,"post3"),new Post(4,2,"post4")})));
        users.add(new User(3,"Mah",new Date(),Arrays.asList(new Post[]{new Post(5,3,"post5"),new Post(6,3,"post6")})));
        users.add(new User(4,"Kane",new Date(),Arrays.asList(new Post[]{new Post(7,4,"post7"),new Post(8,4,"post8")})));
        users.add(new User(5,"Anna",new Date(),Arrays.asList(new Post[]{new Post(9,5,"post9"),new Post(10,5,"post10")})));
        users.add(new User(6,"Bintou",new Date(),Arrays.asList(new Post[]{new Post(11,6,"post11"),new Post(12,6,"post12")})));

    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
       if(user.getId() == null){
           user.setId(++usersCount);
       }
        users.add(user);
       return user;
    }

    public User findOne(int id){
        for (User user : users){
            if (user.getId() ==id )
                return user;
        }
        return null;
    }

    public User deleteById(int id){
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()){
            User user = iterator.next();
            if(user.getId() == id){
                iterator.remove();
                return user;
            }
        }
        return null;
    }

}
