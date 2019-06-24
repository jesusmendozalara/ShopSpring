package com.jesus.ShopSpring.mapper;

import org.springframework.stereotype.Component;

import com.jesus.ShopSpring.dto.ClientDTO;
import com.jesus.ShopSpring.model.Client;

@Component
public class MapperServiceClientImpl implements MapperService<ClientDTO, Client> {

	@Override
	public ClientDTO mapToDto(Client entity) {
		ClientDTO dto = new ClientDTO();
		dto.setDni(entity.getDni());
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		return dto;
	}

	@Override
	public Client mapToEntity(ClientDTO dto) {
		Client entity = new Client();
		entity.setDni(dto.getDni());
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}
}
