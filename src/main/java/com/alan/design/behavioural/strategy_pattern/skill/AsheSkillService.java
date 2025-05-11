package com.alan.design.behavioural.strategy_pattern.skill;

import com.alan.design.behavioural.strategy_pattern.Character;
import org.springframework.stereotype.Service;

@Service
public class AsheSkillService implements SkillStrategy {

    public Character getCharacter() {
        return Character.ASHE;
    }

    public String doQ() {
        return "Ashe do Q";
    }

    public String doW() {
        return "Ashe do W";
    }

    public String doE() {
        return "Ashe do E";
    }

    public String doR() {
        return "Ashe do R";
    }
}