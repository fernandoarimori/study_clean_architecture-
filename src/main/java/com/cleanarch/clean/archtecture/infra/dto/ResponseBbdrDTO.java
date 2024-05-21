package com.cleanarch.clean.archtecture.infra.dto;

import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import com.cleanarch.clean.archtecture.model.valueobj.Ranked;

public record ResponseBbdrDTO(
        String register,
        String name,
        Integer age,
        Ranked ranked
) {
    public ResponseBbdrDTO(Bbdr posted) {
        this(posted.getRegister(), posted.getName(), posted.getAge(), posted.getRank());
    }
}
