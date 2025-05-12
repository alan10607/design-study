package com.alan.design.structural.bridge_pattern;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private MessageLevel level;
    private String body;
}
