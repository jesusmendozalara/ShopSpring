package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesus.ShopSpring.model.Item;
import com.jesus.ShopSpring.repositorie.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	ItemRepository itemRepository;

	@Override
	public Item create(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public List<Item> getAll() {
		return itemRepository.findAll();
	}

	@Override
	public Optional<Item> get(Integer id) {
		return itemRepository.findById(id);
	}

	@Override
	public void update(Item item) {
		Item updatedItem = itemRepository.findById(item.getId()).get();
		updatedItem.setName(item.getName());
		updatedItem.setPrice(item.getPrice());
		updatedItem.setShop(item.getShop());
		itemRepository.save(updatedItem);
	}

	@Override
	public void delete(Integer id) {
		itemRepository.deleteById(id);
	}
}
