package com.SGInventario.invetario.core.ports;

import com.SGInventario.invetario.core.models.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepositoryPort {
    List<Client> findAll();
    Optional<Client> findById(long id);
    Client save(Client client);
    void deleteById(long id);
}
