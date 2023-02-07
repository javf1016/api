package com.superhero.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="superheroes")
@ApiModel(description = "All details about the Superhero. ")
public class Superhero {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The database generated Superhero ID")
	private Long id;
	  
	@Column(nullable = false)
	@ApiModelProperty(notes = "The name of the Superhero")
	private String name;
	  
	@Column(nullable = false)
	@ApiModelProperty(notes = "The alter-ego of the Superhero")
	private String alter;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlter() {
		return alter;
	}

	public void setAlter(String alter) {
		this.alter = alter;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	  
	
  
}