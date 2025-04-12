package com.alan.design.strategypattern.skill;

import com.alan.design.strategypattern.Character;

public interface SkillStrategy {
    public Character getCharacter();

    public String doQ();

    public String doW();

    public String doE();

    public String doR();
}
