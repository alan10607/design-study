package com.alan.design.composite_pattern;

public class FileNode extends SystemNodeComponent {

    public FileNode(String name) {
        super(name);
    }

    @Override
    public void add(SystemNodeComponent node) {
        throw new UnsupportedOperationException("File cannot add children");
    }

    @Override
    public void remove(SystemNodeComponent node) {
        throw new UnsupportedOperationException("File cannot remove children");
    }
}
