package com.example.accessing_data_jpa.dto;

import java.util.List;

public record CustomerDTO(
        Long id,
        String firstName,
        String lastName,
        String email,
        List<IncidentDTO> incidencies
) {
}
