package com.cleanarch.clean.archtecture.infra.dto;

import com.cleanarch.clean.archtecture.model.valueobj.Ranked;

public record UpdateBbdrDto(
        String register,
        String name,
        Integer age,
        Ranked ranked
) {
}
