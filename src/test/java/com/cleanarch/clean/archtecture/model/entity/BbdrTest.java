package com.cleanarch.clean.archtecture.model.entity;

import com.cleanarch.clean.archtecture.model.valueobj.BuilderBbdr;
import com.cleanarch.clean.archtecture.model.valueobj.Ranked;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BbdrTest {
    @Test
    public void creatingNewBbdr() {
        BuilderBbdr builder = new BuilderBbdr();
        var assertTrue = assertThrows(IllegalArgumentException.class, () ->
                builder.createBuilder(
                        "123",
                        "Fernando",
                        17,
                        Ranked.B));
        assertTrue(assertTrue.getMessage().equals("Under ag"));
    }

    @Test
    public void assertingCamps() {
        BuilderBbdr builder = new BuilderBbdr();
        Bbdr empityOne = builder.emptyBuilder();
        Bbdr wrongOne = new Bbdr("123", "AAA", 19, Ranked.B);
//        Bbdr rightOne = new Bbdr("123", "AAA", 18, Rank.B);
        assertEquals("AAA", wrongOne.getName());
    }
}
