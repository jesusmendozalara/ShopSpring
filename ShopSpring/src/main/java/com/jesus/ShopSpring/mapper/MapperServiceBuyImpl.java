package com.jesus.ShopSpring.mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jesus.ShopSpring.dto.BuyDTO;
import com.jesus.ShopSpring.model.Buy;

@Component
public class MapperServiceBuyImpl implements MapperServiceDate<BuyDTO, Buy> {
	@Autowired
	MapperServiceClientImpl mapperServiceClientImpl;
	@Autowired
	MapperServiceShopImpl mapperServiceShopImpl;

	@Override
	public BuyDTO mapToDto(Buy entity) {
		BuyDTO dto = new BuyDTO();
		dto.setClient(mapperServiceClientImpl.mapToDto(entity.getClient()));
		dto.setDate(entity.getDate().toString());
		dto.setId(entity.getId());
		dto.setPrice(entity.getPrice());
		dto.setShop(mapperServiceShopImpl.mapToDto(entity.getShop()));
		return dto;
	}

	@Override
	public Buy mapToEntity(BuyDTO dto) throws ParseException {
		Buy entity = new Buy();
		entity.setClient(mapperServiceClientImpl.mapToEntity(dto.getClient()));
		entity.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(dto.getDate()));
		entity.setId(dto.getId());
		entity.setPrice(dto.getPrice());
		entity.setShop(mapperServiceShopImpl.mapToEntity(dto.getShop()));
		return entity;
	}

}
