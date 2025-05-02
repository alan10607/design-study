package com.alan.design.chain_of_responsibility_pattern;

import com.alan.design.chain_of_responsibility_pattern.validator.DotUsageValidator;
import com.alan.design.chain_of_responsibility_pattern.validator.IsAsciiValidator;
import com.alan.design.chain_of_responsibility_pattern.validator.LengthValidator;
import org.springframework.stereotype.Service;

@Service
public class EmailValidationService {
    private final LengthValidator lengthValidator;

    public EmailValidationService(LengthValidator lengthValidator,
                                  IsAsciiValidator isAsciiValidator,
                                  DotUsageValidator dotUsageValidator) {
        this.lengthValidator = lengthValidator;
        this.lengthValidator.setNext(isAsciiValidator)
                .setNext(dotUsageValidator);
    }

    public void validate(String email) {
        lengthValidator.validate(email);
    }

}
