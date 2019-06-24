package com.jesus.ShopSpring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Provider {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	Integer id;

	String name;
	String dni;

	@ManyToMany(fetch = FetchType.LAZY)
	Set<Item> items = new HashSet<Item>();
}
