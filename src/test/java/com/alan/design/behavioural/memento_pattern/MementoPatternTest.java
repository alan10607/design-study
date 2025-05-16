package com.alan.design.behavioural.memento_pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MementoPatternTest {
    @Autowired
    private SnapshotCaretaker snapshotCaretaker;

    @Test
    void testCreateAndRestoreSnapShot() {
        Article article = new Article();
        article.setTitle("title1");
        article.setContent("content1");
        article.setTags(Arrays.asList("tag1-1", "tag1-2"));
        int index1 = snapshotCaretaker.add(article.createSnapshot());

        article.setTitle("title2");
        article.setContent("content2");
        article.setTags(Arrays.asList("tag2-1", "tag2-2"));
        int index2 = snapshotCaretaker.add(article.createSnapshot());

        article.setTitle("title3");
        article.setContent("content3");
        article.setTags(Arrays.asList("tag3-1", "tag3-2"));


        // start restore memento
        assertEquals(article.getTitle(), "title3");
        assertEquals(article.getContent(), "content3");
        assertEquals(article.getTags(), Arrays.asList("tag3-1", "tag3-2"));

        article.restoreSnapshot(snapshotCaretaker.get(index1));
        assertEquals(article.getTitle(), "title1");
        assertEquals(article.getContent(), "content1");
        assertEquals(article.getTags(), Arrays.asList("tag1-1", "tag1-2"));

        article.restoreSnapshot(snapshotCaretaker.get(index2));
        assertEquals(article.getTitle(), "title2");
        assertEquals(article.getContent(), "content2");
        assertEquals(article.getTags(), Arrays.asList("tag2-1", "tag2-2"));
    }

}