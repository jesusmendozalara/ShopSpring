package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import com.jesus.ShopSpring.model.Buy;
import com.jesus.ShopSpring.model.Item;

public interface BuyService {
	/**
	 * Creates a new buy
	 * 
	 * @param buy
	 * @return
	 */
	Buy create(Buy buy);

	/**
	 * Get all the buys
	 * 
	 * @return
	 */
	List<Buy> getAll();

	/**
	 * Get one buy using a given id
	 * 
	 * @param id
	 * @return
	 */
	Optional<Buy> get(Integer id);

	/**
	 * Updates a buy
	 * 
	 * @param buy
	 */
	void update(Buy buy);

	/**
	 * Adds an item to a buy
	 * 
	 * @param idBuy
	 * @param idItem
	 */
	void addItem(Integer idBuy, Integer idItem);

	/**
	 * Deletes a buy
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * Returns a list with the items of the buy
	 * 
	 * @return
	 */
	List<Item> getItems(Integer idBuy);
}
