package com.alan.design.strategypattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class SkillServiceTest {

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