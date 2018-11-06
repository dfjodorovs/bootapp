package com.example.bootapp.bootapp;

import com.example.bootapp.bootapp.repositories.CountryRepository;
import com.example.bootapp.bootapp.repositories.ImportantPersonRepository;
import com.example.bootapp.bootapp.repositories.UnionRepository;
import com.example.bootapp.bootapp.services.CityService;
import com.example.bootapp.bootapp.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length > 0){
			System.out.println(args[0]);
		}

	}
}
