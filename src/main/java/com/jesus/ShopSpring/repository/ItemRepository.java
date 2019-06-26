package com.jesus.ShopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.ShopSpring.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
