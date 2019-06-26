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

import com.jesus.ShopSpring.dto.ProviderDTO;
import com.jesus.ShopSpring.mapper.MapperServiceProviderImpl;
import com.jesus.ShopSpring.model.Provider;
import com.jesus.ShopSpring.service.ProviderService;

@RestController
@RequestMapping("/provider")
public class ProviderController {
	@Autowired
	MapperServiceProviderImpl mapperServiceProviderImpl;
	@Autowired
	ProviderService providerService;

	/**
	 * Creates a new provider and return it
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderDTO dto) {
		Provider entity = mapperServiceProviderImpl.mapToEntity(dto);
		return ResponseEntity.ok(mapperServiceProviderImpl.mapToDto(providerService.create(entity)));
	}

	/**
	 * Returns the list of providers
	 * @return
	 */
	@GetMapping
	public List<ProviderDTO> getAll() {
		List<Provider> providers = providerService.getAll();
		return providers.stream().map(mapperServiceProviderImpl::mapToDto).collect(Collectors.toList());
	}

	@GetMapping("/{idProvider}")
	public ResponseEntity<ProviderDTO> get(@PathVariable("idProvider") Integer idProvider) {
		Optional<Provider> dto = providerService.get(idProvider);
		if (dto.isPresent()) {
			return ResponseEntity.ok(mapperServiceProviderImpl.mapToDto(dto.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ProviderDTO dto) {
		providerService.update(mapperServiceProviderImpl.mapToEntity(dto));
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{idProvider}/Item/{idItem}")
	public ResponseEntity<?> addItem(@PathVariable("idProvider") Integer idProvider, @PathVariable("idItem") Integer idItem) {
		providerService.addItem(idProvider, idItem);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{idProvider}")
	public ResponseEntity<?> delete(@PathVariable("idProvider") Integer idProvider) {
		if (providerService.get(idProvider).isPresent()) {
			providerService.delete(idProvider);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
