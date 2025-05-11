package com.alan.design.structural.composite_pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class SystemNodeComponent {
    private final String name;
    private final List<SystemNodeComponent> children;

    public SystemNodeComponent(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    protected List<SystemNodeComponent> getChildren() {
        return this.children;
    }

    public abstract void add(SystemNodeComponent node);

    public abstract void remove(SystemNodeComponent node);

    @Override
    public String toString() {
        if (children.isEmpty()) {
            return name;
        } else {
            return name + ": {" + children.stream().map(SystemNodeComponent::toString).collect(Collectors.joining(", ")) + "}";
        }
    }
}
