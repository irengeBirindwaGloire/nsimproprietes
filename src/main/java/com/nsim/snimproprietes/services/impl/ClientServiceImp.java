package com.nsim.snimproprietes.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nsim.snimproprietes.dto.ClientDto;
import com.nsim.snimproprietes.exceptions.EntityNotFoundException;
import com.nsim.snimproprietes.repository.ClientRepository;
import com.nsim.snimproprietes.services.ClientService;

@Service
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    
    @Override
    public Page<ClientDto> findAll() {
        return clientRepository.findAll(Pageable.ofSize(10))
                .map(ClientDto::fromEntity);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            return;
        }
        clientRepository.deleteById(id);
    }

    @Override
    public Page<ClientDto> findAllClients(String keyword, Pageable pageable) {
        if (pageable == null) {
            return Page.empty();
        }
        return clientRepository
                .findByNomContains(keyword, pageable)
                .map(ClientDto::fromEntity);
    }

    @Override
    public ClientDto findById(Long id) {
        if (id == null) {
            return null;
        }
        return clientRepository
                .findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Client avec ID " + id + " n'existe pas."));
    }

    @Override
    public ClientDto save(ClientDto dto) {
        if (dto == null) {
            return null;
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(dto)));
    }

}
