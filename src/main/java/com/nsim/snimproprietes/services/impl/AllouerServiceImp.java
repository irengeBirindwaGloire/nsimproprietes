package com.nsim.snimproprietes.services.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nsim.snimproprietes.dto.AllouerDto;
import com.nsim.snimproprietes.repository.AllouerRepository;
import com.nsim.snimproprietes.services.AllouerService;

@Service
public class AllouerServiceImp implements AllouerService {

    private final AllouerRepository allouerRepository;

    public AllouerServiceImp(AllouerRepository allouerRepository) {
        this.allouerRepository = allouerRepository;
    }

    @Override
    public void deleteAllouerById(Long id) {
        if (id == null) {
            return;
        }
        allouerRepository.deleteById(id);
    }

    @Override
    public List<AllouerDto> findAllouerByClient(String client) {
        
        return allouerRepository.findAllouerByClient(client)
                .stream()
                .map(AllouerDto::fromEntity)
                .toList();
    }

    @Override
    public AllouerDto findAllouerById(Long id) {
        if (id == null) {
            return null;
        }
        return allouerRepository.findById(id)
                .map(AllouerDto::fromEntity)
                .orElse(null);
    }

    @Override
    public Page<AllouerDto> findAllouerServices(Pageable pageable) {
       
        return allouerRepository.findAll(pageable)
                .map(AllouerDto::fromEntity);
    }

    @Override
    public AllouerDto saveAllouer(AllouerDto dto) {
        
        return AllouerDto.fromEntity(
                allouerRepository.save(
                        AllouerDto.toEntity(dto)
                )
        );
    }

}
