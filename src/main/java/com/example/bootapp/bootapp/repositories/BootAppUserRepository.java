package com.example.bootapp.bootapp.repositories;

import com.example.bootapp.bootapp.models.BootAppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BootAppUserRepository extends JpaRepository<BootAppUser,Long> {

    BootAppUser findByUserName(String userName);
    BootAppUser findByPassword(String password);


}
