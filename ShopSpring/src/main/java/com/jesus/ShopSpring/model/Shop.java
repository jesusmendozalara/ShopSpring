package com.jesus.ShopSpring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	Integer id;

	String city;
	Integer postalCode;

	@OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
	Set<Buy> buys = new HashSet<Buy>();
	@OneToMany(mappedBy = "shop", fetch = FetchType.LAZY)
	Set<Item> items = new HashSet<Item>();
}
