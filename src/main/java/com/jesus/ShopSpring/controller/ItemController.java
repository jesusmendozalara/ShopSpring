package com.jesus.ShopSpring.controller;

import java.text.ParseException;
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

import com.jesus.ShopSpring.dto.ItemDTO;
import com.jesus.ShopSpring.mapper.MapperServiceItemImpl;
import com.jesus.ShopSpring.model.Item;
import com.jesus.ShopSpring.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	MapperServiceItemImpl mapperServiceItemImpl;
	@Autowired
	ItemService itemService;

	@PostMapping
	public ResponseEntity<ItemDTO> createItem(@RequestBody ItemDTO dto) {
		Item entity;
		try {
			entity = mapperServiceItemImpl.mapToEntity(dto);
			return ResponseEntity.ok(mapperServiceItemImpl.mapToDto(itemService.create(entity)));
		} catch (ParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public List<ItemDTO> getAll() {
		List<Item> items = itemService.getAll();
		return items.stream().map(mapperServiceItemImpl::mapToDto).collect(Collectors.toList());
	}

	@GetMapping("/{idItem}")
	public ResponseEntity<ItemDTO> get(@PathVariable("idItem") Integer idItem) {
		Optional<Item> dto = itemService.get(idItem);
		if (dto.isPresent()) {
			return ResponseEntity.ok(mapperServiceItemImpl.mapToDto(dto.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody ItemDTO dto) {
		try {
			itemService.update(mapperServiceItemImpl.mapToEntity(dto));
			return ResponseEntity.ok().build();
		} catch (ParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{idItem}")
	public ResponseEntity<?> delete(@PathVariable("idItem") Integer idItem) {
		if (itemService.get(idItem).isPresent()) {
			itemService.delete(idItem);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
