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

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CityService cityService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private ImportantPersonRepository importantPersonRepository;

	@Autowired
	private UnionRepository unionRepository;

	public static void main(String[] args) {
		SpringApplication.run(BootappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length > 0){
			System.out.println(args[0]);
		}

//		Country valsts = countryService.createCountry(101l, "LAT");
//
//
//		String[] cityNames = {"LOndon", "Liverpool"};
//		long[] populations = {100l, 100l};
//		List<City> cities = cityService.createCityList(cityNames,populations);
//		valsts.setCityList(cities);

//		countryRepository.save(valsts);

//		CountryUnion u = new CountryUnion();
//		Set<Country> countries = new HashSet<>();
//		countries.add(countryRepository.findById(100l).get());
//		u.setCountries(countries);
//
//		unionRepository.save(u);
//
//		Optional<Country> countryById = countryRepository.findById(1l);
//		System.out.println(countryById.get());
//
//		City best = new City();
//		best.setName("best");
//		best.setPopulation(100l);
//
//		ImportantPerson person = new ImportantPerson();
//		person.setAge(18);
//		person.setCity(best);
//		person.setHeight(100);
//		person.setName("v");
//		person.setSurname("p");
//
//		importantPersonRepository.save(person);
//
//		List<ImportantPerson> importantPeople = importantPersonRepository.findByName("v");
//		for (ImportantPerson p : importantPeople){
//			System.out.println(p.toString());
//		}

	}
}
