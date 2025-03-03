package com.SGInventario.invetario.core.ports;

import com.SGInventario.invetario.core.models.Supplier;

import java.util.List;
import java.util.Optional;

public interface SupplierRepositoryPort {
    List<Supplier> findAll();
    Optional<Supplier> findById(Long id);
    Supplier save(Supplier supplier);
    void deleteById(Long id);
}
