package com.alan.design.behavioural.state_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StatePatternTest {
    @Autowired
    private DocumentFactory documentFactory;

    @Autowired
    private DocumentService documentService;

    @Test
    void request() {
        Document document = documentFactory.createDocument();
        assertEquals(documentService.getAction(), "");

        document.request();
        assertEquals(documentService.getAction(), "draft");

        document.request();
        assertEquals(documentService.getAction(), "submit");

        document.request();
        assertEquals(documentService.getAction(), "managerReview");

        document.request();
        assertEquals(documentService.getAction(), "published");
    }

}
