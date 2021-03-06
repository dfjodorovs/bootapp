package com.example.bootapp.bootapp.services;

import com.example.bootapp.bootapp.models.BootAppUser;
import com.example.bootapp.bootapp.repositories.BootAppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserAuthenticatonService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BootAppUserRepository bootAppUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        BootAppUser byUserName = bootAppUserRepository.findByUserName(s);

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ADMIN";
            }
        });

        User user = new User(
                byUserName.getUserName(),
                passwordEncoder.encode(byUserName.getPassword()),
                authorityList);

        return user;
    }
}
