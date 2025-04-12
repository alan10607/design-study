package com.alan.design.strategypattern;

public class AsheSkill implements SkillStrategy {
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