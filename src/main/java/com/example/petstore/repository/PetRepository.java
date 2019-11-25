package com.example.petstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.petstore.entity.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Integer> {

	@Query("select p from Pet p where p.userid=:userid")
	List<Pet> findPetsforUser(int userid);

}
