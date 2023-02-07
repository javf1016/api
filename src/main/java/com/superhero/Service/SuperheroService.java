package com.superhero.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.superhero.Entity.Superhero;
import com.superhero.Exception.SuperheroNotFoundException;
import com.superhero.Repository.SuperheroRepository;

@Service
public class SuperheroService {

	@Autowired
    private SuperheroRepository superheroRepository;

	//Find all superheroes
    public List<Superhero> getAllSuperheroes() {
        return superheroRepository.findAll();
    }
    
    //Find superhero by Id
    public Superhero getSuperheroById(Long id) {
        return superheroRepository.findById(id).orElseThrow(() -> new SuperheroNotFoundException(id));
    }
    
    //Find hero name containing
    public List<Superhero> findByNameContaining(String name) {
        return superheroRepository.findByNameContaining(name);
    }
    
    //Update hero
    public Superhero updateSuperhero(Long id, Superhero superheroDetails) {
        Superhero superhero = superheroRepository.findById(id)
                .orElseThrow(() -> new SuperheroNotFoundException(id));

        superhero.setName(superheroDetails.getName());
        superhero.setAlter(superheroDetails.getAlter());

        Superhero updatedSuperhero = superheroRepository.save(superhero);
        return updatedSuperhero;
    }
    
    //Delete superhero by Id
    public void deleteSuperhero(Long id) {
        Superhero superhero = superheroRepository.findById(id)
        		.orElseThrow(() -> new SuperheroNotFoundException(id));
        superheroRepository.delete(superhero);
    }
}