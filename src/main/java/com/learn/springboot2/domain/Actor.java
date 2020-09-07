package com.learn.springboot2.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(updatable = false)
@Id
private Integer actorID;
private String actorName;
private int MobileNumber;
private String Address;

public Integer getActorID() {
	return actorID;
}

public void setActorID(Integer actorID) {
	this.actorID = actorID;
}

public String getActorName() {
	return actorName;
}

public void setActorName(String actorName) {
	this.actorName = actorName;
}

public int getMobileNumber() {
	return MobileNumber;
}

public void setMobileNumber(int mobileNumber) {
	MobileNumber = mobileNumber;
}

public String getAddress() {
	return Address;
}

public void setAddress(String address) {
	Address = address;
}
}
