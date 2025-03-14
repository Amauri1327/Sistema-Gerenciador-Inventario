package com.SGInventario.invetario.core.services;

import com.SGInventario.invetario.core.models.Client;
import com.SGInventario.invetario.core.ports.ClientRepositoryPort;
import com.SGInventario.invetario.services.exceptions.ResourceNotFoundException;

import java.util.List;

public class ClientService {
    private final ClientRepositoryPort clientRepositoryPort;

    public ClientService(ClientRepositoryPort clientRepositoryPort) {
        this.clientRepositoryPort = clientRepositoryPort;
    }

    public List<Client> findAll(){
        return clientRepositoryPort.findAll();
    }

    public Client findById(Long id) {
        return  clientRepositoryPort.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
    }

    public Client save(Client client) {
        return clientRepositoryPort.save(client);
    }

    public void deleteById(Long id){
        clientRepositoryPort.deleteById(id);
    }

}
