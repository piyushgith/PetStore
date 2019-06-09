package com.example.petstore.service;

import java.util.List;

import com.example.petstore.entity.Pet;

public interface PetService {

	List<Pet> findAllPets();

	List<Pet> findPetsForUser(int userid);
	
	String buyPetfromStore(int petid,int userid);

}