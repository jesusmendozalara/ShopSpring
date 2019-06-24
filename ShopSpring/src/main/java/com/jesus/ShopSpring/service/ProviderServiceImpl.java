package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesus.ShopSpring.model.Provider;
import com.jesus.ShopSpring.model.Item;
import com.jesus.ShopSpring.repositorie.ProviderRepository;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	ProviderRepository providerRepository;
	@Autowired
	ItemService itemService;

	@Override
	public Provider create(Provider provider) {
		return providerRepository.save(provider);
	}

	@Override
	public List<Provider> getAll() {
		return providerRepository.findAll();
	}

	@Override
	public Optional<Provider> get(Integer id) {
		return providerRepository.findById(id);
	}

	@Override
	public void update(Provider provider) {
		Provider updatedProvider = providerRepository.findById(provider.getId()).get();
		updatedProvider.setDni(provider.getDni());
		updatedProvider.setName(provider.getName());
		providerRepository.save(updatedProvider);
	}

	@Override
	public void addItem(Integer idProvider, Integer idItem) {
		Optional<Item> item = itemService.get(idItem);
		Optional<Provider> provider = providerRepository.findById(idProvider);
		provider.get().getItems().add(item.get());
		providerRepository.save(provider.get());
	}

	@Override
	public void delete(Integer id) {
		providerRepository.deleteById(id);
	}

}
