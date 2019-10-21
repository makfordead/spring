package com.hh.store.restcontroller;

import com.hh.store.entity.UserEntity;
import com.hh.store.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class controller {

    @Autowired
    private serviceImpl service;


    @GetMapping
    public List<UserEntity> getusers() {

        return service.getusers();
    }

    @PostMapping
    public UserEntity createuser(@RequestBody UserEntity theUserEntity)
    {
        service.save(theUserEntity);
    return theUserEntity;
    }





}
