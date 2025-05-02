package com.alan.design.chain_of_responsibility_pattern.validator;

public abstract class Validator {
    private Validator next;

    public Validator setNext(Validator next) {
        this.next = next;
        return next;
    }

    protected void doNext(String value) {
        if (next != null) {
            next.validate(value);
        }
    }

    public abstract void validate(String value);
}
