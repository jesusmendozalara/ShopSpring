package com.jesus.ShopSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.ShopSpring.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
