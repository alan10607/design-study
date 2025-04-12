package com.alan.design.strategypattern.skill;

import com.alan.design.strategypattern.Character;
import org.springframework.stereotype.Service;

@Service
public class JaxSkillService implements SkillStrategy {

    public Character getCharacter() {
        return Character.JAX;
    }

    public String doQ() {
        return "Jax do Q";
    }

    public String doW() {
        return "Jax do W";
    }

    public String doE() {
        return "Jax do E";
    }

    public String doR() {
        return "Jax do R";
    }
}