package com.cleanarch.clean.archtecture.infra.persistense;

import com.cleanarch.clean.archtecture.model.entity.Bbdr;

public class BbdrMapper {
    public BbdrPersistentese bbdrToPersistenseEntity(Bbdr bbdr){
        return new BbdrPersistentese(bbdr);
    }

    public Bbdr persistenseToBbdr(BbdrPersistentese bbdrPersistentese){
        return new Bbdr(bbdrPersistentese);
    }

}
