package com.learn.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
@NotNull
@NotBlank(message = "Movie Cannot be blank")
private String name;
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable
private List<Actor> actor;



}


