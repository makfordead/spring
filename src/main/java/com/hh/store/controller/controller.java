package com.hh.store.controller;

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
    @CrossOrigin(origins = {"http://localhost:8080", "https://dry-wave-98792.herokuapp.com"})
    public List<UserEntity> getusers() {

        return service.getusers();
    }

    @PostMapping
    @CrossOrigin(origins = {"http://localhost:8080", "https://dry-wave-98792.herokuapp.com"})
    public UserEntity createuser(@RequestBody UserEntity theUserEntity) {
        service.save(theUserEntity);
        return theUserEntity;
    }


}
