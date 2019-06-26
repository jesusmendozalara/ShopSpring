package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesus.ShopSpring.model.Shop;
import com.jesus.ShopSpring.repositorie.ShopRepository;

@Service
public class ShopServiceImpl implements ShopService{
	@Autowired
	ShopRepository shopRepository;

	@Override
	public Shop create(Shop shop) {
		return shopRepository.save(shop);
	}

	@Override
	public List<Shop> getAll() {
		return shopRepository.findAll();
	}

	@Override
	public Optional<Shop> get(Integer id) {
		return shopRepository.findById(id);
	}

	@Override
	public void update(Shop shop) {
		Shop updatedShop = shopRepository.findById(shop.getId()).get();
		updatedShop.setCity(shop.getCity());
		updatedShop.setPostalCode(shop.getPostalCode());
		shopRepository.save(updatedShop);
	}

	@Override
	public void delete(Integer id) {
		shopRepository.deleteById(id);
	}

}
