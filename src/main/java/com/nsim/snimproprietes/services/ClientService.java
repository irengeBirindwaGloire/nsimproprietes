package com.nsim.snimproprietes.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nsim.snimproprietes.dto.ClientDto;

@Service
public interface ClientService {

    public Page<ClientDto> findAllClients(String keyword, Pageable pageable);
    public Page<ClientDto> findAll();

    public ClientDto findById(Long id);

    public ClientDto save(ClientDto dto);

    public void delete(Long id);

}
