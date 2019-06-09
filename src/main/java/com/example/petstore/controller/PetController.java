package com.example.petstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
