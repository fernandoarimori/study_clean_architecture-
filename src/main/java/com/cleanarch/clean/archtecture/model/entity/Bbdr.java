package com.cleanarch.clean.archtecture.model.entity;

import com.cleanarch.clean.archtecture.infra.dto.BbdrPostDto;
import com.cleanarch.clean.archtecture.infra.persistense.BbdrPersistentese;
import com.cleanarch.clean.archtecture.model.valueobj.Ranked;

public class Bbdr {
    private Long id;
    private String register;
    private String name;
    private Integer age;
    private Ranked ranked;

    public Bbdr() {
    }

    public Bbdr(String register, String name, Integer age, Ranked rank) {
        if (age < 18) {
            throw new RuntimeException("Under age");
        }

        this.register = register;
        this.name = name;
        this.age = age;
        this.ranked = rank;
    }

    public Bbdr(BbdrPersistentese bbdrPersistentese) {
        this.id = bbdrPersistentese.getId();
        this.register = bbdrPersistentese.getRegister();
        this.name = bbdrPersistentese.getName();
        this.age = bbdrPersistentese.getAge();
        this.ranked = bbdrPersistentese.getRank();
    }

    public Bbdr(BbdrPostDto dto) {
        this.register = dto.name();
        this.name = dto.register();
        this.age = dto.age();
        this.ranked = dto.ranked();
    }

    public Long getId() {
        return id;
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Ranked getRank() {
        return ranked;
    }

    public void setRank(Ranked rank) {
        this.ranked = rank;
    }
}
