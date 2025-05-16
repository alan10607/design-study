package com.alan.design.behavioural.state_pattern.state;

import com.alan.design.behavioural.state_pattern.Document;
import com.alan.design.behavioural.state_pattern.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PublishedDocumentState implements DocumentState {
    private final DocumentService documentService;

    @Override
    public void handle(Document context) {
        documentService.publishDocument();
        // End of handle chain
    }
}