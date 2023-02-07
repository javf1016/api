package com.superhero.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.Annotation.Timed;
import com.superhero.Entity.Superhero;
import com.superhero.Service.SuperheroService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/superheroes")
@Api(value = "Superhero Management System", description = "Operations related to Superheroes")
public class SuperheroController {

	@Autowired
    private SuperheroService superheroService;

	@Timed
	@GetMapping("/list")
    public List<Superhero> getAllSuperheroes() {
        return superheroService.getAllSuperheroes();
    }
	
	@Timed
	@GetMapping("/hero/{id}")
    public ResponseEntity<Superhero> getSuperheroById(@PathVariable Long id) {
        Superhero superhero = superheroService.getSuperheroById(id);
        if (superhero == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(superhero, HttpStatus.OK);
        }
    }
	
	@Timed
	@GetMapping("hero/search")
	public List<Superhero> searchSuperheroes(@RequestParam("name") String name) {
		return superheroService.findByNameContaining(name);
	}
	
	@Timed
    @PutMapping("/{id}")
    public Superhero updateSuperhero(@PathVariable Long id, @RequestBody Superhero superheroDetails) {
        return superheroService.updateSuperhero(id, superheroDetails);
    }
    
	@Timed
    @DeleteMapping("/delete/{id}")
    public void deleteSuperhero(@PathVariable Long id) {
    	superheroService.deleteSuperhero(id);
    }
    
}