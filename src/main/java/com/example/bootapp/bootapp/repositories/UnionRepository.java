package com.example.bootapp.bootapp.repositories;

import com.example.bootapp.bootapp.models.CountryUnion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnionRepository extends JpaRepository<CountryUnion, Long> {
}
