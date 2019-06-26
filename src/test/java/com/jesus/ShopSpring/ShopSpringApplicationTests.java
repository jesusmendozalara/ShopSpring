package com.jesus.ShopSpring;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jesus.ShopSpring.model.Buy;
import com.jesus.ShopSpring.model.Item;
import com.jesus.ShopSpring.repositorie.BuyRepository;
import com.jesus.ShopSpring.service.BuyServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShopSpringApplicationTests {
	@Mock
	private BuyRepository buyRepository;
	@Mock
	private Buy mockBuy;
	@InjectMocks
	private BuyServiceImpl buyServiceImpl;

	@Test
	public void BuyServiceGetItems() {
		// Given
		Integer id = 1;
		Item item = new Item();
		item.setId(id);
		Buy buy = new Buy();
		buy.setId(2);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		buy.setItems(items);

		// When
		Mockito.when(buyRepository.findById(id)).thenReturn(Optional.ofNullable(buy));
		Mockito.when(mockBuy.getItems()).thenReturn(items);

		// Then
		List<Item> answer = buyServiceImpl.getItems(id);

		assertEquals(answer, items);
	}

}
