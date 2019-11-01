package com.hh.store.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Entity
@Table(name = "Images")
public class Image {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "username")
    private String username;


    @Lob
    @Column(name="Image64")
    @Basic(fetch = FetchType.LAZY)
    private String image64converted;
    public Image(){

    }

    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }

    public String getImage64converted() {
        return image64converted;
    }

    public void setImage64converted(String image64converted) {
        this.image64converted = image64converted;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
