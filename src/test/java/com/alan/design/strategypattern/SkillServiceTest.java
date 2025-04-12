package com.alan.design.strategypattern;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SkillServiceTest {

    @Test
    void testSkillStrategy() {
        SkillService skillService = new SkillService(SkillFactory.getSkillStrategy(Character.GAREN));
        assertEquals(skillService.doQ(), "Garen do Q");
        assertEquals(skillService.doW(), "Garen do W");
        assertEquals(skillService.doE(), "Garen do E");
        assertEquals(skillService.doR(), "Garen do R");

        skillService = new SkillService(SkillFactory.getSkillStrategy(Character.ASHE));
        assertEquals(skillService.doQ(), "Ashe do Q");
        assertEquals(skillService.doW(), "Ashe do W");
        assertEquals(skillService.doE(), "Ashe do E");
        assertEquals(skillService.doR(), "Ashe do R");
    }
}