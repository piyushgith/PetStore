package com.example.petstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.petstore.entity.Pet;
import com.example.petstore.repository.PetRepository;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Override
	public List<Pet> findAllPets() {
		return (List<Pet>) petRepository.findAll();
	}

	@Override
	public List<Pet> findPetsForUser(int userid) {
		return (List<Pet>) petRepository.findPetsforUser(userid);
	}

	@Override
	public String buyPetfromStore(int petid, int userid) {
		return null;
	}

}
