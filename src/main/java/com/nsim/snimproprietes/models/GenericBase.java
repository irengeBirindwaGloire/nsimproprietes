package com.nsim.snimproprietes.models;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import groovy.transform.builder.Builder;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GenericBase<T> {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private T id;
    
    @CreatedDate
    private Instant createdAt;
}
