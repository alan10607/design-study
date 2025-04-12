package com.alan.design.strategypattern;

public class SkillService {
    private final SkillStrategy skillStrategy;

    public SkillService(SkillStrategy skillStrategy) {
        this.skillStrategy = skillStrategy;
    }

    public String doQ() {
        return skillStrategy.doQ();
    }

    public String doW() {
        return skillStrategy.doW();
    }

    public String doE() {
        return skillStrategy.doE();
    }

    public String doR() {
        return skillStrategy.doR();
    }
}