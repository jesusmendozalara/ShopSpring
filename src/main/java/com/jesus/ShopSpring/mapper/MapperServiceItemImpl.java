package com.jesus.ShopSpring.mapper;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jesus.ShopSpring.dto.ItemDTO;
import com.jesus.ShopSpring.model.Item;

@Component
public class MapperServiceItemImpl implements MapperServiceDate<ItemDTO, Item> {
	@Autowired MapperServiceBuyImpl mapperServiceBuyImpl;
	@Autowired MapperServiceShopImpl mapperServiceShopImpl;
	
	@Override
	public ItemDTO mapToDto(Item entity) {
		ItemDTO dto = new ItemDTO();
		dto.setShop(mapperServiceShopImpl.mapToDto(entity.getShop()));
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setPrice(entity.getPrice());
		return dto;
	}

	@Override
	public Item mapToEntity(ItemDTO dto) throws ParseException {
		Item entity = new Item();
		entity.setShop(mapperServiceShopImpl.mapToEntity(dto.getShop()));
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setPrice(dto.getPrice());
		return entity;
	}
}
