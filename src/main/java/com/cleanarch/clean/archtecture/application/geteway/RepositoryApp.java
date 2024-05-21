package com.cleanarch.clean.archtecture.application.geteway;

import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrMapper;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RepositoryApp {
    Bbdr postBbdr(Bbdr bbdr);
    Page<Bbdr> getAll(Pageable pageable);

    Bbdr updateBbrd(Long id, UpdateBbdrDto dto);

    void deleteBbrd(Long id);
}
