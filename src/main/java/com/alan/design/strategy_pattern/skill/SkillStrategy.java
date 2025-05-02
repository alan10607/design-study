package com.alan.design.strategy_pattern.skill;

import com.alan.design.strategy_pattern.Character;

public interface SkillStrategy {
    public Character getCharacter();

    public String doQ();

    public String doW();

    public String doE();

    public String doR();
}
