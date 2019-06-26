package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import com.jesus.ShopSpring.model.Shop;

public interface ShopService {
	/**
	 * Creates a new shop
	 * @param shop
	 * @return
	 */
	Shop create(Shop shop);
	
	/**
	 * Get all the shops
	 * @return
	 */
	List<Shop> getAll();
	
	/**
	 * Get one shop using a given id
	 * @param id
	 * @return
	 */
	Optional<Shop> get(Integer id);
	
	/**
	 * Updates a shop
	 * @param shop
	 */
	void update(Shop shop);
	
	/**
	 * Deletes a shop
	 * @param id
	 */
	void delete(Integer id);
}
