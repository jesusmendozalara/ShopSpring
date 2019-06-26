package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import com.jesus.ShopSpring.model.Provider;

public interface ProviderService {
	/**
	 * Creates a new provider
	 * @param provider
	 * @return
	 */
	Provider create(Provider provider);
	
	/**
	 * Get all the providers
	 * @return
	 */
	List<Provider> getAll();
	
	/**
	 * Get one provider using a given id
	 * @param id
	 * @return
	 */
	Optional<Provider> get(Integer id);
	
	/**
	 * Updates a provider
	 * @param provider
	 */
	void update(Provider provider);
	
	/**
	 * Adds an item to a provider
	 * @param idProvider
	 * @param idItem
	 */
	void addItem(Integer idProvider, Integer idItem);
	
	/**
	 * Deletes a provider
	 * @param id
	 */
	void delete(Integer id);
}
