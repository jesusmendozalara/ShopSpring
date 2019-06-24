package com.jesus.ShopSpring.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	Integer id;

	String name;
	Double price;

	@ManyToMany(fetch = FetchType.LAZY)
	List<Buy> buys = new ArrayList<Buy>();

	@ManyToOne(fetch = FetchType.LAZY)
	Shop shop;

	@ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
	Set<Provider> providers = new HashSet<Provider>();
}
