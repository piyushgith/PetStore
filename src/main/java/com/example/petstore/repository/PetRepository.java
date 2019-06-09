package com.example.petstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.petstore.entity.Pet;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

	@Query("select p from Pet p where p.userid=:userid")
	List<Pet> findPetsforUser(int userid);

}
