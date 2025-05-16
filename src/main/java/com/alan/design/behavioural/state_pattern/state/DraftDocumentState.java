package com.alan.design.behavioural.state_pattern.state;

import com.alan.design.behavioural.state_pattern.Document;
import com.alan.design.behavioural.state_pattern.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DraftDocumentState implements DocumentState {
    private final DocumentService documentService;
    private final SubmitDocumentState nextState;

    @Override
    public void handle(Document context) {
        documentService.draftDocument();
        context.setState(nextState);
    }
}