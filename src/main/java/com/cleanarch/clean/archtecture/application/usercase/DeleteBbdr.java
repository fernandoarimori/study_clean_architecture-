package com.cleanarch.clean.archtecture.application.usercase;

import com.cleanarch.clean.archtecture.application.geteway.RepositoryApp;
import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.infra.gateway.TransferRepository;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class DeleteBbdr implements RepositoryApp {
    private final TransferRepository repository;

    public DeleteBbdr(TransferRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bbdr postBbdr(Bbdr bbdr) {
        return null;
    }

    @Override
    public Page<Bbdr> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Bbdr updateBbrd(Long id, UpdateBbdrDto dto) {
        return null;
    }

    @Override
    public void deleteBbrd(Long id) {
        repository.deleteBbrd(id);
    }
}