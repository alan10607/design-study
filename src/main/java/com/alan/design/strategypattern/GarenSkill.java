package com.alan.design.strategypattern;

public class GarenSkill implements SkillStrategy {
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