package com.jesus.ShopSpring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesus.ShopSpring.model.Buy;
import com.jesus.ShopSpring.model.Item;
import com.jesus.ShopSpring.repository.BuyRepository;

@Service
public class BuyServiceImpl implements BuyService {
	@Autowired
	BuyRepository buyRepository;
	@Autowired
	ItemService itemService;

	@Override
	public Buy create(Buy buy) {
		return buyRepository.save(buy);
	}

	@Override
	public List<Buy> getAll() {
		return buyRepository.findAll();
	}

	@Override
	public Optional<Buy> get(Integer id) {
		return buyRepository.findById(id);
	}

	@Override
	public void update(Buy buy) {
		Buy updatedBuy = buyRepository.findById(buy.getId()).get();
		updatedBuy.setClient(buy.getClient());
		updatedBuy.setDate(buy.getDate());
		updatedBuy.setPrice(buy.getPrice());
		updatedBuy.setShop(buy.getShop());
		buyRepository.save(updatedBuy);
	}

	@Override
	public void delete(Integer id) {
		buyRepository.deleteById(id);
	}

	@Override
	public void addItem(Integer idBuy, Integer idItem) {
		Item item = itemService.get(idItem).get();
		Buy buy = buyRepository.findById(idBuy).get();
		item.getBuys().add(buy);
		buy.setPrice(buy.getPrice() + item.getPrice());
		buyRepository.save(buy);
	}
	
	@Override
	public List<Item> getItems(Integer idBuy) {
		return buyRepository.findById(idBuy).get().getItems();
	}
}
