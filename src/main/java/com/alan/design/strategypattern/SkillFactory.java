package com.alan.design.strategypattern;

public class SkillFactory {

    public static SkillStrategy getSkillStrategy(Character character) {
        switch (character) {
            case GAREN:
                return new GarenSkill();
            case ASHE:
                return new AsheSkill();
            default:
                throw new IllegalStateException("unsupported character");
        }
    }

}
