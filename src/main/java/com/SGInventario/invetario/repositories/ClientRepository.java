package com.SGInventario.invetario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SGInventario.invetario.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}
