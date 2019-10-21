package com.hh.store.restcontroller;

import com.hh.store.entity.user;
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
    public List<user> getusers() {

        return service.getusers();
    }

    @PostMapping
    public user createuser(@RequestBody user theUser)
    {
        service.save(theUser);
    return theUser;
    }





}
