package com.jesus.ShopSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
	private Integer id;
	private String name;
	private Double price;
	private ShopDTO shop;
}
