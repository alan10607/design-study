package com.alan.design.chainofresponsibilitypattern.validator;

import org.springframework.stereotype.Component;

@Component
public class DotUsageValidator extends Validator {

    @Override
    public void validate(String email) {
        if (email.startsWith(".") || email.endsWith(".") || email.contains("..")) {
            throw new IllegalStateException("Illegal dot usage detected");
        }

        doNext(email);
    }

}
