package com.example.bootapp.bootapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthService  implements UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        });
        User user = new User("den",passwordEncoder.encode("pass"),authorityList);
        System.out.println(user.getPassword());
        return user;
    }

}
