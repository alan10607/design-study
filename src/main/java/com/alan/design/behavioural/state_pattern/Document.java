package com.alan.design.behavioural.state_pattern;

import com.alan.design.behavioural.state_pattern.state.DocumentState;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Document {
    private DocumentState state;

    public void request() {
        this.state.handle(this);
    }
}