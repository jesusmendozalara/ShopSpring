package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesus.ShopSpring.model.Client;
import com.jesus.ShopSpring.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client create(Client client) {
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAll() {
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> get(Integer id) {
		return clientRepository.findById(id);
	}

	@Override
	public void update(Client client) {
		Client updatedClient = clientRepository.findById(client.getId()).get();
		updatedClient.setDni(client.getDni());
		updatedClient.setName(client.getName());
		clientRepository.save(updatedClient);
	}

	@Override
	public void delete(Integer id) {
		clientRepository.deleteById(id);
	}

}
