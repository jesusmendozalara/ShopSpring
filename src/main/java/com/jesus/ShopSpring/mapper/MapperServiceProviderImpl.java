package com.jesus.ShopSpring.mapper;

import org.springframework.stereotype.Component;

import com.jesus.ShopSpring.dto.ProviderDTO;
import com.jesus.ShopSpring.model.Provider;

@Component
public class MapperServiceProviderImpl implements MapperService<ProviderDTO, Provider> {

	@Override
	public ProviderDTO mapToDto(Provider entity) {
		ProviderDTO dto = new ProviderDTO();
		dto.setDni(entity.getDni());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public Provider mapToEntity(ProviderDTO dto) {
		Provider entity = new Provider();
		entity.setDni(dto.getDni());
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
	
}
