package com.superheroe.api.integation;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.superhero.Controller.SuperheroController;
import com.superhero.Entity.Superhero;

@SpringBootTest
public class SuperheroControllerIT {
	
	@Autowired
	private SuperheroController superheroController;
	
	@Test
	public void testGetAllSuperheroes() {
		System.out.println("Running integration testGetAllSuperheroes");
		List<Superhero> superheroes = superheroController.getAllSuperheroes();
		assertNotNull(superheroes);
		assertTrue(superheroes.size() > 0);
	}
	
	@Test
	public void testGetSuperhero() {
		System.out.println("Running integration testGetSuperhero");
		Long id = 1L;
		ResponseEntity<Superhero> superhero = superheroController.getSuperheroById(id);
		assertNotNull(superhero);
		assertEquals(id, superhero.getBody().getId());
	}
}
