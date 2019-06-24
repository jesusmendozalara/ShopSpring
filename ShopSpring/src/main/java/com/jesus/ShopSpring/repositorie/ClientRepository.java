package com.jesus.ShopSpring.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jesus.ShopSpring.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
