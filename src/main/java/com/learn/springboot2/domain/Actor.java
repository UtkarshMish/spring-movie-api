package com.learn.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actor {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(updatable = false)
@Id
private Integer actorID;
private String actorName;
private int MobileNumber;
private String Address;
}
