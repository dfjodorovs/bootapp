package com.example.bootapp.bootapp.services;

import com.example.bootapp.bootapp.models.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    public List<City> createCityList(String[] cityNames, long[] populations){
        List<City> cityList = new ArrayList<>();

        for(int i = 0; i < cityNames.length; i++){
            City newCity = new City();
            newCity.setName(cityNames[i]);
            newCity.setPopulation(populations[i]);
            cityList.add(newCity);
        }

        return  cityList;
    }
}
