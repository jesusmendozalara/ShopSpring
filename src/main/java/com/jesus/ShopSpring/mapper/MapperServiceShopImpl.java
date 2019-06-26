package com.jesus.ShopSpring.mapper;

import org.springframework.stereotype.Component;

import com.jesus.ShopSpring.dto.ShopDTO;
import com.jesus.ShopSpring.model.Shop;

@Component
public class MapperServiceShopImpl implements MapperService<ShopDTO, Shop>{

	@Override
	public ShopDTO mapToDto(Shop entity) {
		ShopDTO dto = new ShopDTO();
		dto.setCity(entity.getCity());
		dto.setId(entity.getId());
		dto.setPostalCode(entity.getPostalCode());
		return dto;
	}

	@Override
	public Shop mapToEntity(ShopDTO dto) {
		Shop shop = new Shop();
		shop.setCity(dto.getCity());
		shop.setId(dto.getId());
		shop.setPostalCode(dto.getPostalCode());
		return shop;
	}

}
