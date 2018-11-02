package com.example.bootapp.bootapp.repositories;

import com.example.bootapp.bootapp.models.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
