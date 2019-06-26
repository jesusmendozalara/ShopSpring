package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import com.jesus.ShopSpring.model.Item;

public interface ItemService {
	/**
	 * Creates a new item
	 * @param item
	 * @return
	 */
	Item create(Item item);
	
	/**
	 * Get all the items
	 * @return
	 */
	List<Item> getAll();
	
	/**
	 * Get one item using a given id
	 * @param id
	 * @return
	 */
	Optional<Item> get(Integer id);
	
	/**
	 * Updates a item
	 * @param item
	 */
	void update(Item item);
	
	/**
	 * Deletes a item
	 * @param id
	 */
	void delete(Integer id);
}
