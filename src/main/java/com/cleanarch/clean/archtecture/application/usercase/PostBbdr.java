package com.cleanarch.clean.archtecture.application.usercase;

import com.cleanarch.clean.archtecture.application.geteway.RepositoryApp;
import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.infra.gateway.TransferRepository;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PostBbdr implements RepositoryApp {
    private final TransferRepository repository;

    public PostBbdr(TransferRepository repository) {
        this.repository = repository;
    }

    @Override
    public Bbdr postBbdr(Bbdr bbdr) {
        if (bbdr.getAge()<18){
            throw new RuntimeException("ERROR APPLICATION UNDER AGE");
        }
        return repository.postBbdr(bbdr);
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

    }


}
