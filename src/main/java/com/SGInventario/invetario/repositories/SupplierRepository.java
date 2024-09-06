package com.SGInventario.invetario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SGInventario.invetario.entities.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

}
