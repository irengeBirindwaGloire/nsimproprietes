package com.nsim.snimproprietes.services.impl; 

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nsim.snimproprietes.dto.ProprieteDto;
import com.nsim.snimproprietes.repository.ProprieteRepository;
import com.nsim.snimproprietes.services.ProprieteService;

@Service
public class ProprieteServiceImpl implements ProprieteService {

    private final ProprieteRepository proprieteRepository;

    public ProprieteServiceImpl(ProprieteRepository proprieteRepository) {
        this.proprieteRepository = proprieteRepository;
    }

    @Override
    public void deleteProprieteById(Long id) {
        if (id == null) {
            return;
        }
        proprieteRepository.deleteById(id);
    }

    @Override
    public Page<ProprieteDto> findAllProprietes(String keyword, Pageable pageable) {
        if (keyword != null && !keyword.isEmpty()) {
            return proprieteRepository.findByTitreContains(keyword, pageable).map(ProprieteDto::fromEntity);
        }
        return proprieteRepository.findByTitreContains(keyword, pageable).map(ProprieteDto::fromEntity);
    }

    @Override
    public ProprieteDto findProprieteById(Long id) {
        if (id == null) {
            return null;
        }
        return proprieteRepository.findById(id)
                .map(ProprieteDto::fromEntity)
                .orElseThrow(() -> new RuntimeException("Propriete not found with id: " + id));
    }

    @Override
    public ProprieteDto savePropriete(ProprieteDto dto) {
        return ProprieteDto.fromEntity(proprieteRepository.save(ProprieteDto.toEntity(dto)));
    }

}