package com.hh.store.controller;

import com.hh.store.HelperClasses.IdObject;
import com.hh.store.Utility.Base64ImageSaver;
import com.hh.store.entity.Image;
import com.hh.store.entity.UserEntity;
import com.hh.store.service.serviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController

@RequestMapping("/users")
@CrossOrigin
public class controller {

    @Autowired
    Base64ImageSaver imagesaver;

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

    @PostMapping("/imageupload")
    @CrossOrigin
    public Image save(@RequestBody Image theImage)
    {

    service.save(theImage);
    return theImage;
    }
    @GetMapping("/getAllImages64")
    @CrossOrigin
    public List<Image> getImages()
    {
return service.getImages();
    }



    @PostMapping("/getImagebyid/{username}")
    @CrossOrigin
    public List<Image> getImageByUser(@PathVariable("username") String username)
    {
        return service.getImagebyUsername(username);
    }

    @PostMapping("/DeleteImageById/{id}/{username}")
    @CrossOrigin
    public ResponseEntity<IdObject> delete(@PathVariable("id") String id, @PathVariable("username") String username)
    {
        if(service.deleteImage(id,username)) {
            System.out.println(id);
            System.out.println(username);
            return new ResponseEntity<>(new IdObject(Integer.parseInt(id)),HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
