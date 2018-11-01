package com.example.bootapp.bootapp.repositories;


import com.example.bootapp.bootapp.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{
}
