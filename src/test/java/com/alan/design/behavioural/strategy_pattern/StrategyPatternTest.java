package com.alan.design.behavioural.strategy_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StrategyPatternTest {
    @Autowired
    private SkillService skillService;

    @Test
    void testSkillStrategy() {
        assertEquals(skillService.doQ(Character.GAREN), "Garen do Q");
        assertEquals(skillService.doW(Character.GAREN), "Garen do W");
        assertEquals(skillService.doE(Character.GAREN), "Garen do E");
        assertEquals(skillService.doR(Character.GAREN), "Garen do R");

        assertEquals(skillService.doQ(Character.ASHE), "Ashe do Q");
        assertEquals(skillService.doW(Character.ASHE), "Ashe do W");
        assertEquals(skillService.doE(Character.ASHE), "Ashe do E");
        assertEquals(skillService.doR(Character.ASHE), "Ashe do R");

        assertEquals(skillService.doQ(Character.JAX), "Jax do Q");
        assertEquals(skillService.doW(Character.JAX), "Jax do W");
        assertEquals(skillService.doE(Character.JAX), "Jax do E");
        assertEquals(skillService.doR(Character.JAX), "Jax do R");
    }
}