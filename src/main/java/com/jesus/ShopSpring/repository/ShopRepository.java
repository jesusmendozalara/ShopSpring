package com.jesus.ShopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.ShopSpring.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

}
