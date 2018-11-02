package com.example.bootapp.bootapp.services;

import com.example.bootapp.bootapp.models.Country;
import com.example.bootapp.bootapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Country createCountry(Long population, String language){
        Country newCountry = new Country();
        newCountry.setLanguage(language);
        newCountry.setPopulation(population);

        newCountry = countryRepository.save(newCountry);

        return newCountry;
    }

}
