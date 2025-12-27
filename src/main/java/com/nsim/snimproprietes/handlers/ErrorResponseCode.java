package com.nsim.snimproprietes.handlers;

import java.time.LocalDateTime;

public record ErrorResponseCode(
        LocalDateTime localDateTime,
        int code,
        String titre,
        String message) {

}