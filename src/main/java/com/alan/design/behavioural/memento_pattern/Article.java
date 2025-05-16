package com.alan.design.behavioural.memento_pattern;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Article { // Originator
    private String title;
    private String content;
    private List<String> tags;

    public ArticleSnapshot createSnapshot() {
        return ArticleSnapshot.builder()
                .title(title)
                .content(content)
                .tags(new ArrayList<>(tags)) // deep clone
                .build();
    }

    public void restoreSnapshot(ArticleSnapshot snapshot) {
        this.title = snapshot.getTitle();
        this.content = snapshot.getContent();
        this.tags = new ArrayList<>(snapshot.getTags()); // deep clone

    }

}