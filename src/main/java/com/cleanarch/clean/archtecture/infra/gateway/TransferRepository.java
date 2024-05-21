package com.cleanarch.clean.archtecture.infra.gateway;

import com.cleanarch.clean.archtecture.application.geteway.RepositoryApp;
import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrMapper;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrPersistentese;
import com.cleanarch.clean.archtecture.infra.persistense.JpaOriginalRepository;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class TransferRepository implements RepositoryApp {
        private final JpaOriginalRepository repository;
        private final BbdrMapper bbdrMapper;

    public TransferRepository(JpaOriginalRepository repository, BbdrMapper bbdrMapper) {
        this.repository = repository;

        this.bbdrMapper = bbdrMapper;
    }

    @Override
    public Bbdr postBbdr(Bbdr entity) {
        BbdrPersistentese toSave = bbdrMapper.bbdrToPersistenseEntity(entity);
        this.repository.save(toSave);
        return bbdrMapper.persistenseToBbdr(toSave);
    }

    @Override
    public Page<Bbdr> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(x->bbdrMapper.persistenseToBbdr(x));
    }

    @Override
    public Bbdr updateBbrd(Long id, UpdateBbdrDto dto) {
        BbdrPersistentese foundOne = repository.getReferenceById(id);
        return bbdrMapper.persistenseToBbdr(foundOne);

    }

    @Override
    public void deleteBbrd(Long id) {
        BbdrPersistentese foundOne = repository.getReferenceById(id);
        repository.delete(foundOne);
    }


}
