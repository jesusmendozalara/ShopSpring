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

import com.jesus.ShopSpring.dto.BuyDTO;
import com.jesus.ShopSpring.dto.ItemDTO;
import com.jesus.ShopSpring.mapper.MapperServiceBuyImpl;
import com.jesus.ShopSpring.mapper.MapperServiceItemImpl;
import com.jesus.ShopSpring.model.Buy;
import com.jesus.ShopSpring.service.BuyService;

@RestController
@RequestMapping("/buy")
public class BuyController {
	@Autowired
	MapperServiceBuyImpl mapperServiceBuyImpl;
	@Autowired
	MapperServiceItemImpl mapperServiceItemImpl;
	@Autowired
	BuyService buyService;

	@PostMapping
	public ResponseEntity<BuyDTO> createBuy(@RequestBody BuyDTO dto) {
		Buy entity;
		try {
			entity = mapperServiceBuyImpl.mapToEntity(dto);
			return ResponseEntity.ok(mapperServiceBuyImpl.mapToDto(buyService.create(entity)));
		} catch (ParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping
	public List<BuyDTO> getAll() {
		List<Buy> buys = buyService.getAll();
		return buys.stream().map(mapperServiceBuyImpl::mapToDto).collect(Collectors.toList());
	}

	@GetMapping("/{idBuy}")
	public ResponseEntity<BuyDTO> get(@PathVariable("idBuy") Integer idBuy) {
		Optional<Buy> dto = buyService.get(idBuy);
		if (dto.isPresent()) {
			return ResponseEntity.ok(mapperServiceBuyImpl.mapToDto(dto.get()));
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{idBuy}/items")
	public List<ItemDTO> getItems(@PathVariable("idBuy") Integer idBuy){
		return buyService.getItems(idBuy).stream().map(mapperServiceItemImpl::mapToDto).collect(Collectors.toList());
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody BuyDTO dto) {
		try {
			buyService.update(mapperServiceBuyImpl.mapToEntity(dto));
			return ResponseEntity.ok().build();
		} catch (ParseException e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping("/{idBuy}/item/{idItem}")
	public ResponseEntity<?> addItem(@PathVariable("idBuy") Integer idBuy, @PathVariable("idItem") Integer idItem) {
		buyService.addItem(idBuy, idItem);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{idBuy}")
	public ResponseEntity<?> delete(@PathVariable("idBuy") Integer idBuy) {
		if (buyService.get(idBuy).isPresent()) {
			buyService.delete(idBuy);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
