package com.alan.design.behavioural.state_pattern.state;

import com.alan.design.behavioural.state_pattern.Document;
import com.alan.design.behavioural.state_pattern.DocumentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SubmitDocumentState implements DocumentState {
    private final DocumentService documentService;
    private final ManagerReviewDocumentState nextState;

    @Override
    public void handle(Document context) {
        documentService.submitDocument();
        context.setState(nextState);
    }
}