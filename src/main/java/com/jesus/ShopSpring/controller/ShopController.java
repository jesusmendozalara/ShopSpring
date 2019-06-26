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

import com.jesus.ShopSpring.dto.ShopDTO;
import com.jesus.ShopSpring.mapper.MapperServiceShopImpl;
import com.jesus.ShopSpring.model.Shop;
import com.jesus.ShopSpring.service.ShopService;

@RestController
@RequestMapping("/shop")
public class ShopController {
	@Autowired
	MapperServiceShopImpl mapperServiceShopImpl;
	@Autowired
	ShopService shopService;

	@PostMapping
	public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO dto) {
		Shop entity = mapperServiceShopImpl.mapToEntity(dto);
		return ResponseEntity.ok(mapperServiceShopImpl.mapToDto(shopService.create(entity)));
	}

	@GetMapping
	public List<ShopDTO> getAll() {
		List<Shop> shops = shopService.getAll();
		return shops.stream().map(mapperServiceShopImpl::mapToDto).collect(Collectors.toList());
	}

	@GetMapping("/{idShop}")
	public ResponseEntity<ShopDTO> get(@PathVariable("idShop") Integer idShop) {
		Optional<Shop> dto = shopService.get(idShop);
		if (dto.isPresent()) {
			return ResponseEntity.ok(mapperServiceShopImpl.mapToDto(dto.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ShopDTO dto) {
		shopService.update(mapperServiceShopImpl.mapToEntity(dto));
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{idShop}")
	public ResponseEntity<?> delete(@PathVariable("idShop") Integer idShop) {
		if (shopService.get(idShop).isPresent()) {
			shopService.delete(idShop);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
