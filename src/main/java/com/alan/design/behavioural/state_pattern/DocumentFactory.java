package com.alan.design.behavioural.state_pattern;

import com.alan.design.behavioural.state_pattern.state.DraftDocumentState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentFactory {
    private final DraftDocumentState state;

    public Document createDocument() {
        return new Document(state);
    }

}
