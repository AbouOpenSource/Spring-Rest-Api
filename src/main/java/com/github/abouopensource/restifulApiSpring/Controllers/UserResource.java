package com.github.abouopensource.restifulApiSpring.Controllers;



import com.github.abouopensource.restifulApiSpring.Models.User;
import com.github.abouopensource.restifulApiSpring.exception.UserNotFoundException;
import com.github.abouopensource.restifulApiSpring.service.UserDaoService;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
/*import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;



    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }


    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){

        User user = service.findOne(id);
        if(user ==null){
            throw new UserNotFoundException("id-"+ id);
        }

       /* EntityModel<User> model = new EntityModel<>(user);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkTo.withRel("all-users"));*/
        return user;
    }



    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

         URI location =ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();

    }



    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){

        User user = service.deleteById(id);
        if(user ==null){
            throw new UserNotFoundException("id-"+ id);
        }

    }



}
