package com.SGInventario.invetario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGInventario.invetario.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
