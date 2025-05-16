package com.alan.design.behavioural.memento_pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class ArticleSnapshot {
    private final String title;
    private final String content;
    private final List<String> tags;
}
