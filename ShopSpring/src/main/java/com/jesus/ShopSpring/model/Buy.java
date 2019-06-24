package com.jesus.ShopSpring.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class Buy {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	Integer id;

	Date date;
	Double price;

	@ManyToOne(fetch = FetchType.LAZY)
	Client client;
	@ManyToOne(fetch = FetchType.LAZY)
	Shop shop;
	@ManyToMany(mappedBy = "buys", fetch = FetchType.LAZY)
	List<Item> items = new ArrayList<Item>();
}
