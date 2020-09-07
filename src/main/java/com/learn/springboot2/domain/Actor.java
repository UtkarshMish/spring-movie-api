package com.learn.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actor {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(updatable = false)
@Id
private Integer actorID;
@NotNull
@NotEmpty(message = "Actor Name cannot be Empty")
private String actorName;
private int MobileNumber;
private String Address;
}
