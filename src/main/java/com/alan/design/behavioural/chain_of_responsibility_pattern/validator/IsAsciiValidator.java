package com.alan.design.behavioural.chain_of_responsibility_pattern.validator;

import org.springframework.stereotype.Component;

@Component
public class IsAsciiValidator extends Validator {

    @Override
    public void validate(String email) {
        for (char c : email.toCharArray()) {
            if (c > 127) {
                throw new IllegalStateException("Illegal non-ASCII character detected");
            }
        }

        doNext(email);
    }

}
