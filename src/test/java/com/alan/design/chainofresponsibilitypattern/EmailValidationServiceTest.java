package com.alan.design.chainofresponsibilitypattern;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class EmailValidationServiceTest {
    @Autowired
    private EmailValidationService emailValidationService;

    @Test
    void testValidate() {
        assertThrows(IllegalStateException.class,
                () -> emailValidationService.validate("123456789012345678901234567890@example.com"),
                "Length exceeds the maximum of 30");

        assertThrows(IllegalStateException.class,
                () -> emailValidationService.validate("test.mail@exämple.com"),
                "Illegal non-ASCII character detected");

        assertThrows(IllegalStateException.class,
                () -> emailValidationService.validate("test..mail@example.com"),
                "Illegal dot usage detected");

        assertDoesNotThrow(() -> emailValidationService.validate("test.mail@example.com"));
    }
}