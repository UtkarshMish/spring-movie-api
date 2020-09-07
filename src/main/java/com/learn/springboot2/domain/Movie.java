package com.learn.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(updatable = false, unique = true, insertable = false)
@Id
private Integer id;
private String name;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable
private List<Actor> actor;


public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public List<Actor> getActor() {
	return actor;
}

public void setActor(List<Actor> actor) {
	this.actor = actor;
}


}


