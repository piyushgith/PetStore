package com.example.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.petstore.entity.Pet;
import com.example.petstore.service.PetService;

@RestController
public class PetController {

	@Autowired
	private PetService petService;

	@RequestMapping(value = "/hi", method = RequestMethod.GET)
	public String sayHello() {
		return "Hi There";
	}

	@RequestMapping(value = "/getPets", method = RequestMethod.GET)
	public ResponseEntity<List<Pet>> getAllPets() {
		return new ResponseEntity<List<Pet>>(petService.findAllPets(), HttpStatus.OK);
	}

	@RequestMapping(value = "/getPetsforUser", method = RequestMethod.GET)
	public ResponseEntity<List<Pet>> getAllPetsforUser(@RequestParam("userid") int userId) {
		return new ResponseEntity<List<Pet>>(petService.findPetsForUser(userId), HttpStatus.OK);
	}

	// Correct Way to create json body ID is not needed in case of Post request
	// Select type Json in postman in body in row radio button
	//{ "id":1,"name":"German Sherpard","type":"dog","age":2, "userid":1}

	//@PostMapping(value = "/savePet")
	@RequestMapping(value = "/savePet", method = RequestMethod.POST)
	public ResponseEntity<Pet> saveNewPet1(@RequestBody Pet pet) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<Pet>(petService.savePet(pet), headers, HttpStatus.CREATED);
	}

	//@PostMapping("/savePet")
	public ResponseEntity<Pet> savePetData(@RequestBody Pet pet) {
		return new ResponseEntity<Pet>(petService.savePet(pet),HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/updatePet")
	public ResponseEntity<Pet> updateNewPet(@RequestBody Pet pet) {
		return new ResponseEntity<Pet>(petService.savePet(pet), HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletePet/{id}")
	public ResponseEntity<?> deletePet(@PathVariable("id") Integer id) {
		petService.deletebyId(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
