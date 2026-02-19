package com.scm.entities;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Data
@Entity(name = "user")
@Table(name = "users")
public class User {

    @Id
    private String userId;

    @Column(name="user_name",nullable = false)
    private String name;

    @Column(unique = true,nullable = false)
    private String email;

    private String password;
 
    @Column(length = 1000)
     private String about;

    @Column(length = 1000)
    private String profilePic;

    private String phoneNumber;
    //information
    private boolean enabled=false;

    private boolean emailVerified=false;

    private boolean phoneVerified=false;

  

    //SELF,GOOGLE,FACEBOOK,TWITTER,LINKEDIN,GITHUB

    private Providers provider=Providers.SELF;

    private String providersUserId;


      //add more fileds if needed
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Contact> contacts=new ArrayList<>();

 


}
