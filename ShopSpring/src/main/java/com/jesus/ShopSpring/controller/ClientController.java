package com.jesus.ShopSpring.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jesus.ShopSpring.dto.ClientDTO;
import com.jesus.ShopSpring.mapper.MapperServiceClientImpl;
import com.jesus.ShopSpring.model.Client;
import com.jesus.ShopSpring.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	@Autowired
	MapperServiceClientImpl mapperServiceClientImpl;
	@Autowired
	ClientService clientService;

	@PostMapping
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO dto) {
		Client entity = mapperServiceClientImpl.mapToEntity(dto);
		return ResponseEntity.ok(mapperServiceClientImpl.mapToDto(clientService.create(entity)));
	}

	@GetMapping
	public List<ClientDTO> getAll() {
		List<Client> clients = clientService.getAll();
		return clients.stream().map(mapperServiceClientImpl::mapToDto).collect(Collectors.toList());
	}

	@GetMapping("/{idClient}")
	public ResponseEntity<ClientDTO> get(@PathVariable("idClient") Integer idClient) {
		Optional<Client> dto = clientService.get(idClient);
		if (dto.isPresent()) {
			return ResponseEntity.ok(mapperServiceClientImpl.mapToDto(dto.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ClientDTO dto) {
		clientService.update(mapperServiceClientImpl.mapToEntity(dto));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{idClient}")
	public ResponseEntity<?> delete(@PathVariable("idClient") Integer idClient) {
		if (clientService.get(idClient).isPresent()) {
			clientService.delete(idClient);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
