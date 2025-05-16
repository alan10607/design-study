package com.alan.design.behavioural.memento_pattern;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class SnapshotCaretaker {
    private final List<ArticleSnapshot> snapshots = new CopyOnWriteArrayList<>(); // thread safe

    public int add(ArticleSnapshot snapshot) {
        snapshots.add(snapshot);
        return snapshots.size() - 1;
    }

    public ArticleSnapshot get(int index) {
        return snapshots.get(index);
    }

}
