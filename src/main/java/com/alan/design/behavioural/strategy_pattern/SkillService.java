package com.alan.design.behavioural.strategy_pattern;

import com.alan.design.behavioural.strategy_pattern.skill.SkillStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SkillService {
    private final Map<Character, SkillStrategy> strategyMap;

    @Autowired
    public SkillService(List<SkillStrategy> skillStrategies) {
        this.strategyMap = skillStrategies.stream()
                .collect(Collectors.toMap(SkillStrategy::getCharacter, Function.identity()));
    }

    private SkillStrategy getSkillStrategy(Character character) {
        return Optional.ofNullable(strategyMap.get(character)).orElseThrow(() -> new IllegalStateException("unsupported strategy"));
    }

    public String doQ(Character character) {
        return getSkillStrategy(character).doQ();
    }

    public String doW(Character character) {
        return getSkillStrategy(character).doW();
    }

    public String doE(Character character) {
        return getSkillStrategy(character).doE();
    }

    public String doR(Character character) {
        return getSkillStrategy(character).doR();
    }
}