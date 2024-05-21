package com.cleanarch.clean.archtecture.model.valueobj;

import com.cleanarch.clean.archtecture.model.entity.Bbdr;

public class BuilderBbdr {
    private Bbdr bbdr;
    public Bbdr createBuilder(String register,String name, Integer age, Ranked rank){
        return this.bbdr =new Bbdr(register, name, age, rank);
    }
    public Bbdr emptyBuilder(){
        return this.bbdr = new Bbdr();
    }
}
