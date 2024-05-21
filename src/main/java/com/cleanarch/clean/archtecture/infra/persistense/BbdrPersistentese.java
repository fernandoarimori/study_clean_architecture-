package com.cleanarch.clean.archtecture.infra.persistense;

import com.cleanarch.clean.archtecture.infra.dto.UpdateBbdrDto;
import com.cleanarch.clean.archtecture.model.entity.Bbdr;
import com.cleanarch.clean.archtecture.model.valueobj.Ranked;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity(name = "Bbdr")
@Table(name = "tb_bbdr")
@EqualsAndHashCode(of = "id")
public class BbdrPersistentese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String register;
    private String name;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Ranked ranked;

    public BbdrPersistentese() {
    }

    public BbdrPersistentese(String register, String name, Integer age, Ranked rank) {
        if (age < 18) {
            throw new RuntimeException("Under age");
        }
        this.register = register;
        this.name = name;
        this.age = age;
        this.ranked = rank;
    }

    public BbdrPersistentese(Bbdr bbdr) {
        this.register = bbdr.getRegister();
        this.name = bbdr.getName();
        this.age = bbdr.getAge();
        this.ranked = bbdr.getRank();
    }

    public BbdrPersistentese(Long id, String register, String name, Integer age, Ranked ranked) {
        this.id = id;
        this.register = register;
        this.name = name;
        this.age = age;
        this.ranked = ranked;
    }

    public void update(UpdateBbdrDto dto) {
        this.register = dto.register();
        this.name = dto.name();
        this.age = dto.age();
        this.ranked = dto.ranked();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
