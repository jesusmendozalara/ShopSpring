package com.jesus.ShopSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyDTO {
	private Integer id;
	private String date;
	private Double price;
	private ShopDTO shop;
	private ClientDTO client;
}