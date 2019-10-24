package com.hh.store.controller;

import com.hh.store.entity.UserEntity;
import com.hh.store.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class controller {

    @Autowired
    private serviceImpl service;


    @GetMapping
    @CrossOrigin
    public List<UserEntity> getusers() {

        return service.getusers();
    }

    @PostMapping
    @CrossOrigin
    public UserEntity createuser(@RequestBody UserEntity theUserEntity) {
        service.save(theUserEntity);
        return theUserEntity;
    }
    @PostMapping("/login")
    @CrossOrigin
    public UserEntity login(@RequestBody UserEntity theUserEntity)

    {

UserEntity theUser = service.LoginAuthen(theUserEntity.getUsername(),theUserEntity.getPassword());
return theUser;
    }

}
