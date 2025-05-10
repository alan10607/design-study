package com.alan.design.composite_pattern;

public class FolderNode extends SystemNodeComponent {
    int a = 1;

    public FolderNode(String name) {
        super(name);
    }

    @Override
    public void add(SystemNodeComponent node) {
        getChildren().add(node);
    }

    @Override
    public void remove(SystemNodeComponent node) {
        getChildren().remove(node);
    }
}
