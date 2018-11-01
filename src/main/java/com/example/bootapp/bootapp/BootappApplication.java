package com.example.bootapp.bootapp;

import com.example.bootapp.bootapp.models.City;
import com.example.bootapp.bootapp.models.Country;
import com.example.bootapp.bootapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaAuditing
public class BootappApplication implements CommandLineRunner{

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("it's packed");
		if(args.length > 0){
			System.out.println(args[0]);
		}
		Country valsts = new Country();
		valsts.setLanguage("LV");
		valsts.setPopulation(100l);

		List<City> cityList = new ArrayList<>();

		City riga = new City();
		riga.setName("riga");
		riga.setPopulation(100l);

		City valmiera = new City();
		valmiera.setName("valmiera");
		valmiera.setPopulation(1001l);

		cityList.add(valmiera);
		cityList.add(riga);


		valsts.setCityList(cityList);

		countryRepository.save(valsts);

		Optional<Country> countryById = countryRepository.findById(1l);
		System.out.println(countryById.get());
	}
}
