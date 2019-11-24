package com.example.petstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.petstore.entity.Pet;
import com.example.petstore.repository.PetRepository;

@SpringBootApplication
public class PetstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetstoreApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(PetRepository petRepository) {

		return args -> {
			List<Pet> petList = new ArrayList<Pet>();
			petList.add(new Pet(1, "Tommy", "Dog", 12, 1));
			petList.add(new Pet(2, "Kitty", "Cat", 4, 2));
			petList.add(new Pet(3, "Mohini", "Cow", 5, 2));
			petList.add(new Pet(4, "Mustang", "Horse", 1, 3));

			petList.forEach(x -> petRepository.save(x));
		};

	}

}
