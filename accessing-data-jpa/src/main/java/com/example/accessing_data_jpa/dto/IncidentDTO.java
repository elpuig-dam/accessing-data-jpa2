package com.example.accessing_data_jpa.dto;

import java.time.LocalDateTime;

public record IncidentDTO(
        Long id,
        String titol,
        String estat,
        LocalDateTime dataObertura
) {
}
