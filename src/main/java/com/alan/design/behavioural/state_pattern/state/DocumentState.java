package com.alan.design.behavioural.state_pattern.state;

import com.alan.design.behavioural.state_pattern.Document;

public interface DocumentState {
    void handle(Document context);
}