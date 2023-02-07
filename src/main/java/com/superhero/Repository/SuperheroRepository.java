package com.superhero.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.superhero.Entity.Superhero;

public interface SuperheroRepository extends JpaRepository<Superhero, Long> {
	
	@Query("SELECT s FROM Superhero s WHERE s.name LIKE %:name%")
	List<Superhero> findByNameContaining(String name);

}