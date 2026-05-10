package com.scm.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Entity(name = "user")
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {

  @Id
  private String userId;

  @Column(name = "user_name", nullable = false)
  private String name;

  @Column(unique = true, nullable = false)
  private String email;

  private String password;

  @Column(length = 1000)
  private String about;

  @Column(length = 1000)
  private String profilePic;

  private String phoneNumber;
  // information
  private boolean enabled = true;

  private boolean emailVerified = false;

  private boolean phoneVerified = false;

  // SELF,GOOGLE,FACEBOOK,TWITTER,LINKEDIN,GITHUB

  @Enumerated(value = EnumType.STRING)
  private Providers provider = Providers.SELF;

  private String providersUserId;

  // add more fileds if needed
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  private List<Contact> contacts = new ArrayList<>();

  @ElementCollection(fetch = FetchType.EAGER)
  private List<String> roleList = new ArrayList<>();

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    // list of roles[USer,Admin]
    // collections of SimpleGrandtedAuthority[roles{ADMIN,USER}]

    Collection<SimpleGrantedAuthority> roles = roleList.stream().map(role -> new SimpleGrantedAuthority(role))
        .collect(Collectors.toList());
    return roles;
  }

  // for this porject our email id hmara username hai

  @Override
  public String getUsername() {
    return this.email;

  }

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

}