package com.alan.design.behavioural.chain_of_responsibility_pattern.validator;

import org.springframework.stereotype.Component;

@Component
public class LengthValidator extends Validator {

    @Override
    public void validate(String email) {
        if (email.length() > 30) {
            throw new IllegalStateException("Length exceeds the maximum of 30");
        }

        doNext(email);
    }

}
