package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import com.jesus.ShopSpring.model.Client;


public interface ClientService {
	/**
	 * Creates a new client
	 * @param client
	 * @return
	 */
	Client create(Client client);
	
	/**
	 * Get all the clients
	 * @return
	 */
	List<Client> getAll();
	
	/**
	 * Get one client using a given id
	 * @param id
	 * @return
	 */
	Optional<Client> get(Integer id);
	
	/**
	 * Updates a client
	 * @param client
	 */
	void update(Client client);
	
	/**
	 * Deletes a client
	 * @param id
	 */
	void delete(Integer id);
}
