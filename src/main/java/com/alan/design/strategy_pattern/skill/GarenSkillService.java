package com.alan.design.strategy_pattern.skill;

import com.alan.design.strategy_pattern.Character;
import org.springframework.stereotype.Service;

@Service
public class GarenSkillService implements SkillStrategy {

    public Character getCharacter() {
        return Character.GAREN;
    }

    public String doQ() {
        return "Garen do Q";
    }

    public String doW() {
        return "Garen do W";
    }

    public String doE() {
        return "Garen do E";
    }

    public String doR() {
        return "Garen do R";
    }
}