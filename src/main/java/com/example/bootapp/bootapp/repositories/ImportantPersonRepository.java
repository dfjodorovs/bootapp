package com.example.bootapp.bootapp.repositories;

import com.example.bootapp.bootapp.models.ImportantPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportantPersonRepository extends JpaRepository<ImportantPerson,Long> {


    @Query(
            value = "SELECT * FROM importantperson u",
            nativeQuery = true)
    public List<ImportantPerson> getAllPeople();

    List<ImportantPerson> findByName(String name);


}
