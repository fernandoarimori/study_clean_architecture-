package com.cleanarch.clean.archtecture.application.usercase;

import com.cleanarch.clean.archtecture.application.geteway.RepositoryApp;
import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.infra.gateway.TransferRepository;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrMapper;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrPersistentese;
import com.cleanarch.clean.archtecture.infra.persistense.JpaOriginalRepository;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UpdateBbdr implements RepositoryApp {
    private final JpaOriginalRepository repository;
    private final BbdrMapper bbdrMapper;

    public UpdateBbdr(JpaOriginalRepository repository, BbdrMapper bbdrMapper) {
        this.repository = repository;
        this.bbdrMapper = bbdrMapper;
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
        BbdrPersistentese foundOne = repository.getReferenceById(id);
        foundOne.update(dto);
        repository.save(foundOne);
        return bbdrMapper.persistenseToBbdr(foundOne);
    }

    @Override
    public void deleteBbrd(Long id) {

    }
}
